private boolean isPageLoadedComplete = false; //declare at class level

public void WebViewSettings(){

webView = (WebView) findViewById(R.id.webview);
webView.getSettings().setJavaScriptEnabled(true);
webView.getSettings().setBuiltInZoomControls(true);
webView.getSettings().setSupportZoom(true);
webView.getSettings().setLoadWithOverviewMode(true);
webView.canGoBack();

 /**
  *I had put code here
  */
Timer myTimer = new Timer();
    //Start this timer when you create you task
myTimer.schedule(loaderTask, 3000); // 3000 is delay in millies

webView.setWebViewClient(new WebViewClient(){

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (Uri.parse(url).getHost().equals(urlString)) {
            // This is my web site, so do not override; let my WebView load the page
            return false;
        }
        // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
        return true;
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        // Check to see if there is a progress dialog
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setTitle("Loading...");
            progressDialog.setMessage("Please wait.");
            //progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);
            progressDialog.show();
        }
    }

    @Override
    public void onPageFinished(WebView view, String url) {
            isPageLoadedComplete = true;
        // Page is done loading;
        // hide the progress dialog and show the webview
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
            webView.setEnabled(true);
        }
    }

    @Override
    public void onReceivedSslError (WebView view, SslErrorHandler handler, SslError error) {
         handler.proceed();
    }

    @Override
    public void onReceivedError(WebView view, int errorCod,String description, String failingUrl) {
        Toast.makeText(context, "Your Internet Connection May not be active Or " + description , Toast.LENGTH_LONG).show();
    }
});
}

 /**
  *This class is invoke when you times up.
  */
 class loaderTask extends TimerTask {
  public void run() {
    System.out.println("Times Up");
    if(isPageLoadedComplete){
    }else{
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
            webView.setEnabled(true);
        }
        //show error message as per you need.
    }
  }
}