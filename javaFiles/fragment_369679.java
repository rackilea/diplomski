// Enable javascript for the view
mWebView = (WebView) findViewById(R.id.webview);
mWebView.getSettings().setJavaScriptEnabled(true);
mWebview.setWebViewClient(new WebViewClient() {
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Toast.makeText(this, description, Toast.LENGTH_SHORT).show();
        }
    });

    mWebview .loadUrl("http://www.facebook.com/apple.fruit");