private class MyWebClient extends WebViewClient {
      @Override
      public void onPageStarted(WebView view, String url, 
         // here show the dialog
      }
      public void onPageFinished(WebView view, String url) {
         // here dismiss it
      }
 }