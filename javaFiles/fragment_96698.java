@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.detail_activity);
    ButterKnife.bind(this);
    Article object = (Article) getIntent().getParcelableExtra("myDataKey");
    article_webview.getSettings().setJavaScriptEnabled(true);
    article_webview.setWebViewClient(new WebViewClient());
    article_webview.loadUrl(object.getUrl());

}