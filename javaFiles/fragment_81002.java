public final String WEBVIEW = "WEBVIEW_com.maxsoft.poker";
public final String NATIVE_APP = "NATIVE_APP";


public String getHTMLPageSource(String url){
    switchContextTo(WEBVIEW);
    getDriver().navigate().to(url);
    return getDriver().getPageSource();
}

public void switchContextTo(String context){
    if (context.toLowerCase().equals(WEBVIEW.toLowerCase())) {
        getDriver().context(WEBVIEW); // set context to WEBVIEW_1
    } else {
        getDriver().context(NATIVE_APP); // set context to NATIVE_APP
    }
}