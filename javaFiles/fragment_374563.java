public class MainActivity extends AppCompatActivity { 

private WebView view;

    /** Called when the activity is first created. */ 

    public void onBackPressed (){ 

        if (view.isFocused() && view.canGoBack()) {
            view.goBack();
        } 
        else { 
            super.onBackPressed(); 
        } 
    } 


    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (WebView) findViewById(R.id.webView);

        view.getSettings().setJavaScriptEnabled(true);

        view.setWebViewClient(new MyCustomWebViewClient());
        view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);


        view.loadUrl("http://url");


    } 



    private class MyCustomWebViewClient extends WebViewClient {
        @Override 
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

           view.loadUrl(url);
            return true; 
        } 


        @Override 
        public void onPageFinished(WebView view, String url) {
            //hide loading image 
            findViewById(R.id.imageLoading1).setVisibility(View.GONE);
            //show webview 
            findViewById(R.id.webView).setVisibility(View.VISIBLE);
        } 


        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            if (view.canGoBack()) {
                view.goBack();
            } else { 
                view.loadUrl("file:///android_asset/index.html");
            } 
            Toast.makeText(getBaseContext(), description, Toast.LENGTH_LONG).show();
        } 

    } 
}