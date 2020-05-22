mWebView.setWebViewClient(new WebViewClient() {
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        mWebView.loadUrl("file:///android_asset/myerrorpage.html");

    }
});