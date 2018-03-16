package com.kgb.twitchapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Krzysztof Betlej <k.betlej@samsung.com>.
 * @date 3/16/18
 * @copyright Copyright (c) 2016 by Samsung Electronics Polska Sp. z o. o.
 */

public class TwitchTopGames {
    @SerializedName("data")
    @Expose
    private List<TwitchGame> mData;

    public void setData(List<TwitchGame> data) {
        mData = data;
    }

    public List<TwitchGame> getData() {
        return mData;
    }
}
