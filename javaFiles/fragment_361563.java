public class MainActivity extends AppCompatActivity {

private WebView myWebView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    myWebView = (WebView) findViewById(R.id.webView);
    myWebView.setWebViewClient(new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }
    });

}

public void btn1(View view) {
    myWebView.loadUrl("http://user:password@10.0.1.16/?button2");
}

public void btn2(View view) {
    myWebView.loadUrl("http://user:password@10.0.1.16/?button3");
}

public void btn3(View view) {
    myWebView.loadUrl("http://user:password@10.0.1.16/?button1");
}