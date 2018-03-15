package com.kgb.twitchapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("channel")
    @Expose
    private String channel;
    @SerializedName("follows")
    @Expose
    private String follows;
    @SerializedName("commercial")
    @Expose
    private String commercial;
    @SerializedName("stream_key")
    @Expose
    private String streamKey;
    @SerializedName("chat")
    @Expose
    private String chat;
    @SerializedName("features")
    @Expose
    private String features;
    @SerializedName("subscriptions")
    @Expose
    private String subscriptions;
    @SerializedName("editors")
    @Expose
    private String editors;
    @SerializedName("teams")
    @Expose
    private String teams;
    @SerializedName("videos")
    @Expose
    private String videos;

    public void setFollows(String follows) {
        this.follows = follows;
    }

    public void setCommercial(String commercial) {
        this.commercial = commercial;
    }

    public void setStreamKey(String streamKey) {
        this.streamKey = streamKey;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public void setSubscriptions(String subscriptions) {
        this.subscriptions = subscriptions;
    }

    public void setEditors(String editors) {
        this.editors = editors;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getFollows() {
        return follows;
    }

    public String getCommercial() {
        return commercial;
    }

    public String getStreamKey() {
        return streamKey;
    }

    public String getChat() {
        return chat;
    }

    public String getFeatures() {
        return features;
    }

    public String getSubscriptions() {
        return subscriptions;
    }

    public String getEditors() {
        return editors;
    }

    public String getTeams() {
        return teams;
    }

    public String getVideos() {
        return videos;
    }
}
