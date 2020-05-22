web.setWebViewClient(new myWebClient());
//add this below line
web.setWebChromeClient(new WebChromeClient() {
   public void onProgressChanged(WebView view, int progress) {
        progressBar.setProgress(progress);
   }
 });