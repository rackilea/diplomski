webView.setWebViewClient(new WebViewClient(){
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        if ("myLogoutUrl".equals(url)){
            //do stuff
        }
        super.onPageStarted(view, url, favicon);
    }
});