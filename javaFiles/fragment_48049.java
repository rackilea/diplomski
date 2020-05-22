private void myUIUpdate(View view) {
    String url = "http://gsmarena.com";
    myWebView = (WebView) view.findViewById(R.id.webViewGames);
    myWebView.setWebChromeClient(new myWebViewClient());
    myWebView.getSettings().setJavaScriptEnabled(true);
    progress = (ProgressBar) view.findViewById(R.id.progressBar);
    myWebView.loadUrl(url);
    progress.setMax(100);

    myWebView.setWebViewClient(new WebViewClient() {

        @Override
        public boolean shouldOverrideUrlLoading(WebView View, String url) {
            View.loadUrl(url);
            GamesFragment.this.progress.setProgress(0);
            return true;
        }

    });

    myWebView.setOnKeyListener(new android.view.View.OnKeyListener() {@Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                WebView webView = (WebView) v;

                switch (keyCode) {
                    case KeyEvent.KEYCODE_BACK:
                        if (webView.canGoBack()) {
                            webView.goBack();
                            return true;
                        }
                        break;
                }
            }
            return false;
        }
    });
}