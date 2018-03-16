package com.kgb.twitchapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Krzysztof Betlej <k.betlej@samsung.com>.
 * @date 3/16/18
 * @copyright Copyright (c) 2016 by Samsung Electronics Polska Sp. z o. o.
 */

public class TwitchGame {
    @SerializedName("id")
    @Expose
    private long mId;

    @SerializedName("name")
    @Expose
    private String mName;

    @SerializedName("box_art_url")
    @Expose
    private String mArtUrl;

    public void setId(long id) {
        mId = id;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setArtUrl(String artUrl) {
        mArtUrl = artUrl;
    }

    public long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getArtUrl() {
        return mArtUrl;
    }
}
