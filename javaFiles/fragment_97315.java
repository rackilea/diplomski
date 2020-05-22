WebView webView = (WebView) findViewById(R.id.xyzfragment);
    WebSettings webSettings = webView.getSettings();

    webSettings.setJavaScriptEnabled(true);

    webView.loadUrl("Enter_the_URL_of_your_published_map");