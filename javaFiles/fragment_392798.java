public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle(getTitleResourceId());
    setActionBarContentView(R.layout.info_template);

    WebView engine = (WebView) findViewById(R.id.web_view);  
    engine.setBackgroundColor(0);
    engine.setBackgroundResource(R.drawable.bg);
    engine.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
    engine.getSettings().setBuiltInZoomControls(true);
    engine.loadUrl(getUrlToLoad());
    engine.setWebViewClient(new WebViewWithin());
}