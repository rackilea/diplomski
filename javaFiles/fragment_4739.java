webView.setWebViewClient(new WebViewClient() {

    @Override
    public void onPageFinished(WebView view, String url)
    {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            webView.evaluateJavascript(js, null);
        } else {
            webView.loadUrl(js);
        }
    }

});