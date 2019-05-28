package com.github.vmvalle.kafkaconsumer.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("screen_name")
    private String screenName;
    @JsonProperty("location")
    private String location;
    @JsonProperty("protected")
    private Boolean _protected;
    @JsonProperty("verified")
    private Boolean verified;
    @JsonProperty("followers_count")
    private Integer followersCount;
    @JsonProperty("friends_count")
    private Integer friendsCount;
    @JsonProperty("listed_count")
    private Integer listedCount;
    @JsonProperty("favourites_count")
    private Integer favouritesCount;
    @JsonProperty("statuses_count")
    private Integer statusesCount;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("utc_offset")
    private Object utcOffset;
    @JsonProperty("time_zone")
    private Object timeZone;
    @JsonProperty("geo_enabled")
    private Boolean geoEnabled;
    @JsonProperty("lang")
    private String lang;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public User() {
    }

    /**
     * @param friendsCount
     * @param location
     * @param favouritesCount
     * @param screenName
     * @param timeZone
     * @param geoEnabled
     * @param listedCount
     * @param lang
     * @param _protected
     * @param id
     * @param createdAt
     * @param verified
     * @param name
     * @param utcOffset
     * @param followersCount
     * @param statusesCount
     */
    public User(Long id, String name, String screenName, String location, Boolean _protected, Boolean verified, Integer followersCount, Integer friendsCount, Integer listedCount, Integer favouritesCount, Integer statusesCount, String createdAt, Object utcOffset, Object timeZone, Boolean geoEnabled, String lang) {
        super();
        this.id = id;
        this.name = name;
        this.screenName = screenName;
        this.location = location;
        this._protected = _protected;
        this.verified = verified;
        this.followersCount = followersCount;
        this.friendsCount = friendsCount;
        this.listedCount = listedCount;
        this.favouritesCount = favouritesCount;
        this.statusesCount = statusesCount;
        this.createdAt = createdAt;
        this.utcOffset = utcOffset;
        this.timeZone = timeZone;
        this.geoEnabled = geoEnabled;
        this.lang = lang;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("screen_name")
    public String getScreenName() {
        return screenName;
    }

    @JsonProperty("screen_name")
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("protected")
    public Boolean getProtected() {
        return _protected;
    }

    @JsonProperty("protected")
    public void setProtected(Boolean _protected) {
        this._protected = _protected;
    }

    @JsonProperty("verified")
    public Boolean getVerified() {
        return verified;
    }

    @JsonProperty("verified")
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @JsonProperty("followers_count")
    public Integer getFollowersCount() {
        return followersCount;
    }

    @JsonProperty("followers_count")
    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    @JsonProperty("friends_count")
    public Integer getFriendsCount() {
        return friendsCount;
    }

    @JsonProperty("friends_count")
    public void setFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
    }

    @JsonProperty("listed_count")
    public Integer getListedCount() {
        return listedCount;
    }

    @JsonProperty("listed_count")
    public void setListedCount(Integer listedCount) {
        this.listedCount = listedCount;
    }

    @JsonProperty("favourites_count")
    public Integer getFavouritesCount() {
        return favouritesCount;
    }

    @JsonProperty("favourites_count")
    public void setFavouritesCount(Integer favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    @JsonProperty("statuses_count")
    public Integer getStatusesCount() {
        return statusesCount;
    }

    @JsonProperty("statuses_count")
    public void setStatusesCount(Integer statusesCount) {
        this.statusesCount = statusesCount;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("utc_offset")
    public Object getUtcOffset() {
        return utcOffset;
    }

    @JsonProperty("utc_offset")
    public void setUtcOffset(Object utcOffset) {
        this.utcOffset = utcOffset;
    }

    @JsonProperty("time_zone")
    public Object getTimeZone() {
        return timeZone;
    }

    @JsonProperty("time_zone")
    public void setTimeZone(Object timeZone) {
        this.timeZone = timeZone;
    }

    @JsonProperty("geo_enabled")
    public Boolean getGeoEnabled() {
        return geoEnabled;
    }

    @JsonProperty("geo_enabled")
    public void setGeoEnabled(Boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    @JsonProperty("lang")
    public String getLang() {
        return lang;
    }

    @JsonProperty("lang")
    public void setLang(String lang) {
        this.lang = lang;
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