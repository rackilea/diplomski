webView.setWebViewClient(new WebViewClient() {
@Override
public boolean shouldOverrideUrlLoading(WebView view, String url) {
    if (url.startsWith("abcd://")) {
        // your code
        return true;
    }
    return false;
}
});