@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String url = "http://www.kylesutherland.com";

    WebView view = (WebView) findViewById(R.id.webview);
    view.getSettings().setJavaScriptEnabled(true);
    view.loadUrl(url);
    //starting from here
    view.setWebViewClient(new WebViewClient() {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
}