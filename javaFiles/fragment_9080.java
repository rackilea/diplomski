@JsonProperty("server-id")
public Integer getServerId() {
    return serverId;
}

// added
@JsonProperty("server-id")
public void setServerId(Integer serverId) {
    this.serverId = serverId;
}

@JsonProperty("server-url")
public String getServer_url() {
    return server_url;
}

// added
@JsonProperty("server-url")
public void setServer_url(String server_url) {
    this.server_url = server_url;
}