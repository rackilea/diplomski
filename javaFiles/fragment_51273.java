protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    WebView mWebView=new WebView(YOUR_CLASS_NAME.this);
    mWebView.getSettings().setJavaScriptEnabled(true);
    mWebView.getSettings().setPluginsEnabled(true);
    mWebView.getSettings().setAllowFileAccess(true);
    mWebView.loadUrl(url);
    setContentView(mWebView);
}