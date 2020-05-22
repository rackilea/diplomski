String userAgent = System.getProperty( "http.agent" );
Log.e("User agent",userAgent);
myWebView.setWebViewClient(new WebViewClient());
myWebView.getSettings().setUserAgentString(userAgent);
myWebView.getSettings().setJavaScriptEnabled(true);
myWebView.getSettings().setAppCacheEnabled(true);
myWebView.getSettings().setDomStorageEnabled(true);
myWebView.loadUrl(url);