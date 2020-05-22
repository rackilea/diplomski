ProgressBar pb = (ProgressBar).findViewById(R.id.webview_progressBar1);

     wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {

                super.onPageFinished(view, url);

                pb.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                super.onPageStarted(view, url, favicon);

                pb.setVisibility(View.VISIBLE);

            }

        });