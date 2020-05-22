public class CustomJsonData{

@JsonProperty("web_block")
private List<WebBlock> webBlock = new ArrayList<WebBlock>();
@JsonProperty("port_block")
private List<PortBlock> portBlock = new ArrayList<PortBlock>();
@JsonProperty("user")
private List<User> user = new ArrayList<User>();

public CustomJsonData() {
}

public List<WebBlock> getWebBlock() {
    return webBlock;
}

public void setWebBlock(List<WebBlock> webBlock) {
    this.webBlock = webBlock;
}

public List<PortBlock> getPortBlock() {
    return portBlock;
}

public void setPortBlock(List<PortBlock> portBlock) {
    this.portBlock = portBlock;
}

public List<User> getUser() {
    return user;
}

public void setUser(List<User> user) {
    this.user = user;
}

}

class PortBlock {

@JsonProperty("port")
private String port;
@JsonProperty("protocol")
private String protocol;
@JsonProperty("action")
private String action;

public PortBlock() {
}

public String getPort() {
    return port;
}

public void setPort(String port) {
    this.port = port;
}

public String getProtocol() {
    return protocol;
}

public void setProtocol(String protocol) {
    this.protocol = protocol;
}

public String getAction() {
    return action;
}

public void setAction(String action) {
    this.action = action;
}

}

class User {

@JsonProperty("username")
private String username;

public User() {
}

public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

}

class WebBlock {

@JsonProperty("url")
private String url;
@JsonProperty("action")
private String action;

public WebBlock() {
}

public String getUrl() {
    return url;
}

public void setUrl(String url) {
    this.url = url;
}

public String getAction() {
    return action;
}

public void setAction(String action) {
    this.action = action;
}

}