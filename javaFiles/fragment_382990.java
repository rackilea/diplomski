public class webview1 extends Activity
   public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.settings);
   WebView v = (WebView) findViewById(R.id.webView1);
   v.loadUrl("http://www.google.com");