yourWebView.setWebViewClient(new WebViewClient() {

   public void onPageFinished(WebView view, String url) {
        // add your button here
    } 
}); 

yourWebView.loadUrl(url);