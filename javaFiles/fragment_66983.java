final String[] finalURL = {""};
String url1 = "goo.gl/RvoAZH";
webView.loadUrl(url1);
webView.setWebViewClient(new WebViewClient() {
public void onPageFinished(WebView view, String url) {
System.out.println(webView.getUrl()); // whatever way to debug
finalURL[0] = webView.getUrl();
}
});