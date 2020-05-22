final String source = "http://google.com";
        final WebView webView = (WebView) rootView.findViewById(R.id.home_webview);
        //webView.loadUrl(url);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                //Do some like progress bar loading here.

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                webView.loadUrl(source);

            }
        });