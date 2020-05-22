webView.setWebChromeClient(new WebChromeClient() {

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        progDailog.show();
        view.loadUrl(url);

        return true;                
    }

    public void onPageFinished(WebView view, final String url) {
        progDailog.dismiss();
    }
});