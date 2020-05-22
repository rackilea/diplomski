boolean loadingFinished = true;
boolean redirect = false;

mWebView.setWebViewClient(new WebViewClient() {

   @Override
   public boolean shouldOverrideUrlLoading(WebView view, String urlNewString) {
       if (!loadingFinished) {
          redirect = true;
       }

   loadingFinished = false;
   webView.loadUrl(urlNewString);
   return true;
   }

   @Override
   public void onPageStarted(WebView view, String url) {
        loadingFinished = false;
        //SHOW LOADING IF IT ISNT ALREADY VISIBLE  
    }

   @Override
   public void onPageFinished(WebView view, String url) {
       if(!redirect){
          loadingFinished = true;
       }

       if(loadingFinished && !redirect){
         //HIDE LOADING IT HAS FINISHED
       } else{
          redirect = false; 
       }

    }
});