public Url addLocationToUrl(Url url) {  
    Url newUrl = url;
    //do something with url
    return newUrl;
}   

loadUrl(addLocationToUrl(someUrl));

//and in your WebViewClient
@Override
public boolean shouldOverrideUrlLoading(WebView view, String url) {
    mWebView.loadUrl(addLocationToUrl(someUrl));
    return true;
}