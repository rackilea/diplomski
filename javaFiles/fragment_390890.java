mWebView = (WebView) findViewById(R.id.webview); 
mWebView.getSettings().setJavaScriptEnabled(true);
mWebView.setWebChromeClient(new WebChromeClient());
mWebView.setWebViewClient(new WebViewClient(){
    @Override
    public void onPageFinished(WebView view, String url) {

        String javascript="javascript: document.getElementById('someid').innerHTML='Hello World!';";
        view.loadUrl(javascript);
    }
});
mWebView.loadUrl(URL);