@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.webviewex);

    // Get reference of WebView from layout/webviewex.xml
    mWebView = (WebView) findViewById(R.id.webView1);

    setUpWebViewDefaults(mWebView);

    // Get URL from Intent
    String URL = getIntent().getExtras().getString("URL");

    // Load website
    mWebView.loadUrl(URL);
}