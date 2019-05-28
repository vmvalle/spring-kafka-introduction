package com.github.vmvalle.kafkaconsumer.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;


//@Document(indexName = "twitter", type = "tweets")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tweet {

    //@Id
    @JsonProperty("id")
    private Long id;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("text")
    private String text;
    @JsonProperty("source")
    private String source;
    @JsonProperty("truncated")
    private Boolean truncated;
    @JsonProperty("in_reply_to_status_id")
    private Object inReplyToStatusId;
    @JsonProperty("in_reply_to_status_id_str")
    private Object inReplyToStatusIdStr;
    @JsonProperty("in_reply_to_user_id")
    private Object inReplyToUserId;
    @JsonProperty("in_reply_to_user_id_str")
    private Object inReplyToUserIdStr;
    @JsonProperty("in_reply_to_screen_name")
    private Object inReplyToScreenName;
    @JsonProperty("user")
    private User user;
    @JsonProperty("geo")
    private Object geo;
    @JsonProperty("quoted_status_id_str")
    private String quotedStatusIdStr;
    @JsonProperty("is_quote_status")
    private Boolean isQuoteStatus;
    @JsonProperty("quote_count")
    private Integer quoteCount;
    @JsonProperty("reply_count")
    private Integer replyCount;
    @JsonProperty("retweet_count")
    private Integer retweetCount;
    @JsonProperty("favorite_count")
    private Integer favoriteCount;
    @JsonProperty("favorited")
    private Boolean favorited;
    @JsonProperty("retweeted")
    private Boolean retweeted;
    @JsonProperty("possibly_sensitive")
    private Boolean possiblySensitive;
    @JsonProperty("filter_level")
    private String filterLevel;
    @JsonProperty("lang")
    private String lang;
    @JsonProperty("timestamp_ms")
    private String timestampMs;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Tweet() {
    }

    /**
     *
     * @param text
     * @param filterLevel
     * @param geo
     * @param retweeted
     * @param replyCount
     * @param inReplyToUserIdStr
     * @param timestampMs
     * @param retweetCount
     * @param inReplyToScreenName
     * @param quoteCount
     * @param truncated
     * @param lang
     * @param possiblySensitive
     * @param id
     * @param inReplyToStatusId
     * @param favoriteCount
     * @param source
     * @param favorited
     * @param inReplyToStatusIdStr
     * @param quotedStatusIdStr
     * @param createdAt
     * @param inReplyToUserId
     * @param user
     * @param isQuoteStatus
     * @param quotedStatusId
     */
    public Tweet(String createdAt, Long id, String text, String source, Boolean truncated, Object inReplyToStatusId, Object inReplyToStatusIdStr, Object inReplyToUserId, Object inReplyToUserIdStr, Object inReplyToScreenName, User user, Object geo, Integer quotedStatusId, String quotedStatusIdStr, Boolean isQuoteStatus, Integer quoteCount, Integer replyCount, Integer retweetCount, Integer favoriteCount, Boolean favorited, Boolean retweeted, Boolean possiblySensitive, String filterLevel, String lang, String timestampMs) {
        super();
        this.createdAt = createdAt;
        this.id = id;
        this.text = text;
        this.source = source;
        this.truncated = truncated;
        this.inReplyToStatusId = inReplyToStatusId;
        this.inReplyToStatusIdStr = inReplyToStatusIdStr;
        this.inReplyToUserId = inReplyToUserId;
        this.inReplyToUserIdStr = inReplyToUserIdStr;
        this.inReplyToScreenName = inReplyToScreenName;
        this.user = user;
        this.geo = geo;
        this.quotedStatusIdStr = quotedStatusIdStr;
        this.isQuoteStatus = isQuoteStatus;
        this.quoteCount = quoteCount;
        this.replyCount = replyCount;
        this.retweetCount = retweetCount;
        this.favoriteCount = favoriteCount;
        this.favorited = favorited;
        this.retweeted = retweeted;
        this.possiblySensitive = possiblySensitive;
        this.filterLevel = filterLevel;
        this.lang = lang;
        this.timestampMs = timestampMs;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("truncated")
    public Boolean getTruncated() {
        return truncated;
    }

    @JsonProperty("truncated")
    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

    @JsonProperty("in_reply_to_status_id")
    public Object getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    @JsonProperty("in_reply_to_status_id")
    public void setInReplyToStatusId(Object inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    @JsonProperty("in_reply_to_status_id_str")
    public Object getInReplyToStatusIdStr() {
        return inReplyToStatusIdStr;
    }

    @JsonProperty("in_reply_to_status_id_str")
    public void setInReplyToStatusIdStr(Object inReplyToStatusIdStr) {
        this.inReplyToStatusIdStr = inReplyToStatusIdStr;
    }

    @JsonProperty("in_reply_to_user_id")
    public Object getInReplyToUserId() {
        return inReplyToUserId;
    }

    @JsonProperty("in_reply_to_user_id")
    public void setInReplyToUserId(Object inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    @JsonProperty("in_reply_to_user_id_str")
    public Object getInReplyToUserIdStr() {
        return inReplyToUserIdStr;
    }

    @JsonProperty("in_reply_to_user_id_str")
    public void setInReplyToUserIdStr(Object inReplyToUserIdStr) {
        this.inReplyToUserIdStr = inReplyToUserIdStr;
    }

    @JsonProperty("in_reply_to_screen_name")
    public Object getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    @JsonProperty("in_reply_to_screen_name")
    public void setInReplyToScreenName(Object inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("geo")
    public Object getGeo() {
        return geo;
    }

    @JsonProperty("geo")
    public void setGeo(Object geo) {
        this.geo = geo;
    }

    @JsonProperty("quoted_status_id_str")
    public String getQuotedStatusIdStr() {
        return quotedStatusIdStr;
    }

    @JsonProperty("quoted_status_id_str")
    public void setQuotedStatusIdStr(String quotedStatusIdStr) {
        this.quotedStatusIdStr = quotedStatusIdStr;
    }

    @JsonProperty("is_quote_status")
    public Boolean getIsQuoteStatus() {
        return isQuoteStatus;
    }

    @JsonProperty("is_quote_status")
    public void setIsQuoteStatus(Boolean isQuoteStatus) {
        this.isQuoteStatus = isQuoteStatus;
    }

    @JsonProperty("quote_count")
    public Integer getQuoteCount() {
        return quoteCount;
    }

    @JsonProperty("quote_count")
    public void setQuoteCount(Integer quoteCount) {
        this.quoteCount = quoteCount;
    }

    @JsonProperty("reply_count")
    public Integer getReplyCount() {
        return replyCount;
    }

    @JsonProperty("reply_count")
    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    @JsonProperty("retweet_count")
    public Integer getRetweetCount() {
        return retweetCount;
    }

    @JsonProperty("retweet_count")
    public void setRetweetCount(Integer retweetCount) {
        this.retweetCount = retweetCount;
    }

    @JsonProperty("favorite_count")
    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    @JsonProperty("favorite_count")
    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    @JsonProperty("favorited")
    public Boolean getFavorited() {
        return favorited;
    }

    @JsonProperty("favorited")
    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    @JsonProperty("retweeted")
    public Boolean getRetweeted() {
        return retweeted;
    }

    @JsonProperty("retweeted")
    public void setRetweeted(Boolean retweeted) {
        this.retweeted = retweeted;
    }

    @JsonProperty("possibly_sensitive")
    public Boolean getPossiblySensitive() {
        return possiblySensitive;
    }

    @JsonProperty("possibly_sensitive")
    public void setPossiblySensitive(Boolean possiblySensitive) {
        this.possiblySensitive = possiblySensitive;
    }

    @JsonProperty("filter_level")
    public String getFilterLevel() {
        return filterLevel;
    }

    @JsonProperty("filter_level")
    public void setFilterLevel(String filterLevel) {
        this.filterLevel = filterLevel;
    }

    @JsonProperty("lang")
    public String getLang() {
        return lang;
    }

    @JsonProperty("lang")
    public void setLang(String lang) {
        this.lang = lang;
    }

    @JsonProperty("timestamp_ms")
    public String getTimestampMs() {
        return timestampMs;
    }

    @JsonProperty("timestamp_ms")
    public void setTimestampMs(String timestampMs) {
        this.timestampMs = timestampMs;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}