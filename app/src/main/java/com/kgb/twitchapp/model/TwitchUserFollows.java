package com.kgb.twitchapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Krzysztof Betlej <k.betlej@samsung.com>.
 * @date 3/16/18
 * @copyright Copyright (c) 2016 by Samsung Electronics Polska Sp. z o. o.
 */

public class TwitchUserFollows {
    public static class TwitchPagination {
        @SerializedName(("cursor"))
        @Expose
        private String mCursor;

        public void setCursor(String cursor) {
            mCursor = cursor;
        }

        public String getCursor() {
            return mCursor;
        }
    }
    public static class TwitchFollow {
        @SerializedName("from_id")
        @Expose
        private long mFromId;

        @SerializedName("to_id")
        @Expose
        private long mToId;

        @SerializedName("followed_at")
        @Expose
        private String mFollowedAt;

        public void setFromId(long fromId) {
            mFromId = fromId;
        }

        public void setToId(long toId) {
            mToId = toId;
        }

        public void setFollowedAt(String followedAt) {
            mFollowedAt = followedAt;
        }

        public long getFromId() {
            return mFromId;
        }

        public long getToId() {
            return mToId;
        }

        public String getFollowedAt() {
            return mFollowedAt;
        }
    }

    @SerializedName("total")
    @Expose
    private int mTotal;

    @SerializedName("data")
    @Expose
    private List<TwitchFollow> mFollows;

    @SerializedName(("pagination"))
    @Expose
    private TwitchPagination mPagination;

    public void setTotal(int total) {
        mTotal = total;
    }

    public void setPagination(TwitchPagination pagination) {
        mPagination = pagination;
    }

    public void setFollows(List<TwitchFollow> follows) {
        mFollows = follows;
    }

    public int getTotal() {
        return mTotal;
    }

    public TwitchPagination getPagination() {
        return mPagination;
    }

    public List<TwitchFollow> getFollows() {
        return mFollows;
    }
}
