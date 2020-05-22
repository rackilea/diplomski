WebView webview = new WebView(this);      
  webview.setWebViewClient(new WebViewClient() {  
      @Override  
      public boolean shouldOverrideUrlLoading(WebView view, String url)  
      {  
        view.loadUrl(url); //this is controversial - see comments and other answers
        return true;  
      }  
    });                 
  setContentView(webview);      
  webview.loadUrl([MY URL]);