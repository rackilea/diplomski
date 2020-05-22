@Override
protected void onStart()
{
    super.onStart();
    myWebView = (WebView) findViewById(R.id.WebView);
    myWebView.setWebViewClient(new WebViewClient());
    myWebView.loadUrl("http://www.google.com");
}