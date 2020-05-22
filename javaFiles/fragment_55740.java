public class MainActivity extends Activity {
    final WebView mWebView;
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webView)
    }
}