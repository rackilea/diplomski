//Make sure links in the webview is handled by the webview and not sent to a full browser
myWebView.setWebViewClient(new WebViewClient() {
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        progressBar.show();
    }

    @Override
     public void onPageFinished(WebView view, String url) {
         Log.i(TAG, "Finished loading URL: " +url);
         if (progressBar.isShowing()) {
             progressBar.dismiss();
         }
     }

});