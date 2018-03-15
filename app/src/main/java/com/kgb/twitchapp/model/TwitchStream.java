package com.kgb.twitchapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TwitchStream {

    @SerializedName("stream")
    @Expose
    private Stream stream;
    @SerializedName("links")
    @Expose
    private Links links;

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

}
