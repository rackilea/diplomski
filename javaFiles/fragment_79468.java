@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_with_webview);
    final Intent intent = getIntent();
    if (null != intent) {
        if (intent.hasExtra("fileToShow")) {
            WebView myWebView = (WebView) findViewById(R.id.my_web_view);
            myWebView.loadUrl("file:///" + intent.getExtras().getString("fileToShow");
        }
    }
}