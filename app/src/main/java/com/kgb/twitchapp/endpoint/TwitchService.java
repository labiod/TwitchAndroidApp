package com.kgb.twitchapp.endpoint;

import com.kgb.twitchapp.model.TwitchChannel;
import com.kgb.twitchapp.model.TwitchStream;
import com.kgb.twitchapp.model.TwitchUser;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;


public interface TwitchService {
    @GET("users/{channel_name}")
    Observable<TwitchUser> userInfo(@Header("Client-ID") String clientId, @Path("channel_name") String channelName);

    @GET("streams/{channel_id}")
    Observable<TwitchStream> streamInfo(@Header("Client-ID") String clientId, @Path("channel_id") long channelId);

    @GET("channels/{channel_name}")
    Observable<TwitchChannel> channelInfo(@Header("Client-ID") String clientId, @Path("channel_name") String channelName);

}
