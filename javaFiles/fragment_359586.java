private String url = "http://www.quicksprout.com/images/foggygoldengatebridge.jpg";

public String getUrl() {
    Clients.evalJavaScript("jq('#anchor')[0].href='" + url + "';");
    return url;
}