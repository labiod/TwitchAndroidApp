package com.kgb.twitchapp.api.adapter;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Function;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @author Krzysztof Betlej <k.betlej@samsung.com>.
 * @date 3/16/18
 * @copyright Copyright (c) 2016 by Samsung Electronics Polska Sp. z o. o.
 */

public class RxCallAdapterWithErrorHandling<T> extends CallAdapter.Factory {
    private class AdapterWrapper implements CallAdapter<T, Observable<?>> {

        private final Retrofit mRetrofit;
        private final CallAdapter<T, ?> mWrapper;

        public AdapterWrapper(Retrofit retrofit, CallAdapter wrapper) {
            mRetrofit = retrofit;
            mWrapper = wrapper;
        }


        @Override
        public Type responseType() {
            return mWrapper.responseType();
        }

        @Override
        public Observable<?> adapt(Call<T> call) {
            return ((Observable) mWrapper.adapt(call)).onErrorResumeNext(throwable -> {
                return Observable.error(asRetrofitException((Throwable) throwable));
            });
        }

        private RetrofitException asRetrofitException(Throwable throwable) {
            // We had non-200 http error
            if (throwable instanceof HttpException) {
                HttpException httpException = (HttpException) throwable;
                Response response = httpException.response();
                return RetrofitException.httpError(response.raw().request().url().toString(), response, mRetrofit);
            }
            // A network error happened
            if (throwable instanceof IOException) {
                return RetrofitException.networkError((IOException) throwable);
            }

            // We don't know what happened. We need to simply convert to an unknown error

            return RetrofitException.unexpectedError(throwable);
        }
    }

    public static RxCallAdapterWithErrorHandling create() {
        return create(null);
    }

    public static RxCallAdapterWithErrorHandling create(Scheduler scheduler) {
        return new RxCallAdapterWithErrorHandling(scheduler);
    }
    private RxJava2CallAdapterFactory mOriginAdapter;

    private RxCallAdapterWithErrorHandling(Scheduler scheduler) {
        if (scheduler != null) {
            mOriginAdapter = RxJava2CallAdapterFactory.createWithScheduler(scheduler);
        } else {
            mOriginAdapter = RxJava2CallAdapterFactory.create();
        }
    }
    @Nullable
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        return new AdapterWrapper(retrofit, mOriginAdapter.get(returnType, annotations, retrofit));
    }
}
