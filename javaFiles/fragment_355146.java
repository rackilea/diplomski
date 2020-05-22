@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.some_layout);
    Bundle extras = getIntent().getExtras();
    String value = "file:///android_asset/default_page.html";
    if(extras !=null) {
       value = extras.getString("keyHTML");
    }
    webView = (WebView)findViewById(R.id.webview);
    webView.loadUrl(value);
}