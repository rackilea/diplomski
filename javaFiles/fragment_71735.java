webview.setWebViewClient(new WebViewClient() {
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        //Users will be notified in case there's an error (i.e. no internet connection)
        Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
    }

    public void onPageFinished(WebView view, String url) {
        CookieSyncManager.getInstance().sync();
    }
);