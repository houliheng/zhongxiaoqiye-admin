package com.gqcc.meim.common.wechat.media;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.gqcc.meim.common.wechat.util.DateDeserializer;
import com.gqcc.meim.common.wechat.util.DateDeserializer;

/**
 * Created by exizhai on 11/21/2015.
 */
public class Media {

    private MediaType type;

    @JsonProperty("media_id")
    private String mediaId;

    @JsonDeserialize(using = DateDeserializer.class)
    @JsonProperty("created_at")
    private Date createdAt;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
