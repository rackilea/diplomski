final WebView webview = (WebView)findViewById(R.id.browser);

// enable JavaScript
webview.getSettings().setJavaScriptEnabled(true);

webview.setWebViewClient(new WebViewClient() {
    @Override
    public void onPageFinished(WebView view, String url)
    {
        // here you can do whatever you want
        webview.loadUrl("javascript:(function() { " +
                "document.getElementsByTagName('reply_button').style.display='none'; " +
                "})()");
    }
});

webview.loadUrl("http://www.webiste.com");