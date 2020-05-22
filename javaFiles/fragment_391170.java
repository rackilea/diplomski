public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView;
    private ImageView mSplashView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWebView = (WebView) findViewById(R.id.webview);
        mSplashView = (ImageView) findViewById(R.id.splash_view);
        mWebView.getSettings().setJavaScriptEnabled(true); // enable javascript

        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mSplashView.setVisibility(View.GONE);
                mWebView.setVisibility(View.VISIBLE);
                Toast.makeText(getBaseContext(), "Page Loaded.", Toast.LENGTH_SHORT).show();
            }
        });

        mWebView.loadUrl("http://yoururlhere.com");
        mWebView.setVisibility(View.GONE);
        mSplashView.setVisibility(View.VISIBLE);
    }
}