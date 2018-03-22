package com.kgb.twitchapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.kgb.twitchapp.api.endpoint.TwitchService;
import com.kgb.twitchapp.model.TwitchChannel;
import com.kgb.twitchapp.model.TwitchGame;
import com.kgb.twitchapp.model.TwitchStream;
import com.kgb.twitchapp.model.TwitchTopGames;
import com.kgb.twitchapp.model.TwitchUser;
import com.kgb.twitchapp.model.TwitchUserFollows;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private static final String TWITCH_BASE_URL = "https://api.twitch.tv/";

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
        String userName = getString(R.string.twitch_user_name);
        userInfo.setOnClickListener(v -> {
            Observable<TwitchUser> observable = service.userInfo(getString(R.string.twitch_client_id), userName);
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
            Observable<TwitchChannel> observable = service.channelInfo(getString(R.string.twitch_client_id), userName);
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

        Button topGamesButton = findViewById(R.id.get_top_game);
        topGamesButton.setOnClickListener(v -> {
            Observable<TwitchTopGames> observable = service.topGame(getString(R.string.twitch_client_id));
            observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(topGames -> {
                        StringBuilder builder = new StringBuilder();
                        for (TwitchGame game : topGames.getData()) {
                            builder.append("\n[").append(game.getId()).append("]");
                            builder.append("Name:").append(game.getName());
                            builder.append("\nart url:").append(game.getArtUrl())
                                    .append("\n*****************");
                        }
                        info.setText(builder.toString());
                    });
        });

        Button userFollowsButtons = findViewById(R.id.get_user_follows);
        userFollowsButtons.setOnClickListener(v -> {
            Observable<TwitchUserFollows> observable = service.userFollows(getString(R.string.twitch_client_id), mId);
            observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(userFollows-> {
                        StringBuilder builder = new StringBuilder();
                        Log.d(TAG, "onCreate: total:" + userFollows.getTotal());
                        for (TwitchUserFollows.TwitchFollow game : userFollows.getFollows()) {
                            builder.append("[ from:")
                                    .append(game.getFromId())
                                    .append(" to")
                                    .append(game.getToId())
                                    .append("]\n");
                        }
                        info.setText(builder.toString());
                    }, e -> {
                        Log.e(TAG, "exception:", e);
                    });
        });

        Button followersButtons = findViewById(R.id.get_user_followers);
        followersButtons.setOnClickListener(v -> {
            Observable<TwitchUserFollows> observable = service.userFollowers(getString(R.string.twitch_client_id), mId);
            observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(userFollows-> {
                        StringBuilder builder = new StringBuilder();
                        Log.d(TAG, "onCreate: total:" + userFollows.getTotal());
                        for (TwitchUserFollows.TwitchFollow game : userFollows.getFollows()) {
                            builder.append("[ from:")
                                    .append(game.getFromId())
                                    .append(" to")
                                    .append(game.getToId())
                                    .append("]\n");
                        }
                        info.setText(builder.toString());
                    }, e -> {
                        Log.e(TAG, "exception:", e);
                    });
        });


    }
}
