browser.setWebViewClient(new WebViewClient() {    
      @Override
      public void onPageStarted(WebView view, String url, Bitmap favicon) {
           super.onPageStarted(view, url, favicon);

           // set here your URL in Your EditText
            urlbox.setText(url);    

       }    

       @Override
       public boolean shouldOverrideUrlLoading(WebView view, String url) {
           view.loadUrl(url);
           return true;
       }

       @Override
       public void onPageFinished(WebView view, String url) {

       }
  });