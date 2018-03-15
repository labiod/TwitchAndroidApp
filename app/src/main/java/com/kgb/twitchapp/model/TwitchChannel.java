package com.kgb.twitchapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TwitchChannel {

    @SerializedName("mature")
    @Expose
    private boolean mature;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("broadcaster_language")
    @Expose
    private String mBroadcasterLanguage;

    @SerializedName("display_name")
    @Expose
    private String mDisplayName;

    @SerializedName("game")
    @Expose
    private String game;

    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("_id")
    @Expose
    private long mId;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("created_at")
    @Expose
    private String mCreatedAt;

    @SerializedName("updated_at")
    @Expose
    private String mUpdatedAt;

    @SerializedName("partner")
    @Expose
    private boolean mPartner;

    @SerializedName("logo")
    @Expose
    private String mLogoUri;

    @SerializedName("video_banner")
    @Expose
    private String mVideoBannerUri;

    @SerializedName("profile_banner")
    @Expose
    private String mProfileBannerUri;

    @SerializedName("profile_banner_background_color")
    @Expose
    private String mProfileBannerBackgroundColor;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("views")
    @Expose
    private int views;

    @SerializedName("followers")
    @Expose
    private int followers;

    @SerializedName("links")
    @Expose
    private Links links;

    @SerializedName("delay")
    @Expose
    private String delay;

    @SerializedName("banner")
    @Expose
    private String mBannerUri;

    @SerializedName("background")
    @Expose
    private String mBackgroundUri;

    public void setMature(boolean mature) {
        this.mature = mature;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBroadcasterLanguage(String broadcasterLanguage) {
        this.mBroadcasterLanguage = broadcasterLanguage;
    }

    public void setDisplayName(String displayName) {
        this.mDisplayName = displayName;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setId(long id) {
        this.mId = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedAt(String createdAt) {
        this.mCreatedAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.mUpdatedAt = updatedAt;
    }

    public void setLogoUri(String logoUri) {
        mLogoUri = logoUri;
    }

    public void setVideoBannerUri(String videoBannerUri) {
        this.mVideoBannerUri = videoBannerUri;
    }

    public void setProfileBannerUri(String profileBannerUri) {
        this.mProfileBannerUri = profileBannerUri;
    }

    public void setProfileBannerBackgroundColor(String profileBannerBackgroundColor) {
        this.mProfileBannerBackgroundColor = profileBannerBackgroundColor;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public void setBannerUri(String bannerUri) {
        this.mBannerUri = bannerUri;
    }

    public void setBackgroundUri(String backgroundUri) {
        mBackgroundUri = backgroundUri;
    }

    public void setPartner(boolean partner) {
        mPartner = partner;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public boolean isMature() {
        return mature;
    }

    public String getStatus() {
        return status;
    }

    public String getBroadcasterLanguage() {
        return mBroadcasterLanguage;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public String getGame() {
        return game;
    }

    public String getLanguage() {
        return language;
    }

    public long getId() {
        return mId;
    }

    public String getName() {
        return name;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public String getLogoUri() {
        return mLogoUri;
    }

    public String getVideoBannerUri() {
        return mVideoBannerUri;
    }

    public String getProfileBannerUri() {
        return mProfileBannerUri;
    }

    public String getProfileBannerBackgroundColor() {
        return mProfileBannerBackgroundColor;
    }

    public String getUrl() {
        return url;
    }

    public int getViews() {
        return views;
    }

    public int getFollowers() {
        return followers;
    }

    public String getDelay() {
        return delay;
    }

    public String getBannerUri() {
        return mBannerUri;
    }

    public String getBackgroundUri() {
        return mBackgroundUri;
    }

    public boolean isPartner() {
        return mPartner;
    }
}
