package com.kgb.twitchapp.api.endpoint;

import com.kgb.twitchapp.model.TwitchChannel;
import com.kgb.twitchapp.model.TwitchStream;
import com.kgb.twitchapp.model.TwitchTopGames;
import com.kgb.twitchapp.model.TwitchUser;
import com.kgb.twitchapp.model.TwitchUserFollows;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface TwitchService {
    @GET("kraken/users/{channel_name}")
    Observable<TwitchUser> userInfo(@Header("Client-ID") String clientId, @Path("channel_name") String channelName);

    @GET("kraken/streams/{channel_id}")
    Observable<TwitchStream> streamInfo(@Header("Client-ID") String clientId, @Path("channel_id") long channelId);

    @GET("kraken/channels/{channel_name}")
    Observable<TwitchChannel> channelInfo(@Header("Client-ID") String clientId, @Path("channel_name") String channelName);

    @GET("helix/games/top")
    Observable<TwitchTopGames> topGame(@Header("Client-ID") String clientId);

    @GET("helix/users/follows")
    Observable<TwitchUserFollows> userFollows(@Header("Client-ID") String clientId, @Query("from_id") long userId);


    @GET("helix/users/follows")
    Observable<TwitchUserFollows> userFollowers(@Header("Client-ID") String clientId, @Query("to_id") long userId);

}
