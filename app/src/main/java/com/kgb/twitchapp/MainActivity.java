package com.kgb.twitchapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.kgb.twitchapp.endpoint.TwitchService;
import com.kgb.twitchapp.model.TwitchChannel;
import com.kgb.twitchapp.model.TwitchStream;
import com.kgb.twitchapp.model.TwitchUser;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private static final String TWITCH_BASE_URL = "https://api.twitch.tv/kraken/";
    public static final String TEST_USER_NAME = "labiod";

    private long mId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TWITCH_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        TwitchService service = retrofit.create(TwitchService.class);
        TextView info = findViewById(R.id.info_view);
        Button userInfo = findViewById(R.id.get_user_info);
        userInfo.setOnClickListener(v -> {
            Observable<TwitchUser> observable = service.userInfo(getString(R.string.twitch_client_id), TEST_USER_NAME);
            observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(user -> {
                        mId = user.getId();
                        StringBuilder builder = new StringBuilder();
                        builder.append("display name :").append(user.getDisplayName());
                        builder.append("\nname :").append(user.getName());
                        builder.append("\nuser id :").append(user.getId());
                        builder.append("\nuser bio :").append(user.getBio());
                        builder.append("\nuser type :").append(user.getType());
                        info.setText(builder.toString());
                    });
        });
        Button streamInfo = findViewById(R.id.get_stream_info);
        streamInfo.setOnClickListener(v -> {
            Observable<TwitchStream> observable = service.streamInfo(getString(R.string.twitch_client_id), mId);
            observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(user -> {
                        StringBuilder builder = new StringBuilder();
                        info.setText(builder.toString());
                    });
        });

        Button channelInfo = findViewById(R.id.get_channel_info);
        channelInfo.setOnClickListener(v -> {
            Observable<TwitchChannel> observable = service.channelInfo(getString(R.string.twitch_client_id), TEST_USER_NAME);
            observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(channel -> {
                        StringBuilder builder = new StringBuilder();
                        builder.append("display name :").append(channel.getDisplayName());
                        builder.append("\nname :").append(channel.getName());
                        builder.append("\nuser id :").append(channel.getId());
                        builder.append("\nfollowers :").append(channel.getFollowers());
                        builder.append("\nnumber of views :").append(channel.getViews());
                        builder.append("\naccount url :").append(channel.getUrl());
                        builder.append("\ngame :").append(channel.getGame());
                        builder.append("\nstatus :").append(channel.getStatus());
                        info.setText(builder.toString());
                    });
        });


    }
}
