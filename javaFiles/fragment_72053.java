public class WebActivity extends Activity
     {

      public void onCreate(Bundle savedInstanceState)
      { 
     super.onCreate(savedInstanceState);
     WebView mywebview = (WebView) findViewById(R.id.webview);
     WebSettings webSettings = mywebview.getSettings();
     webSettings.setJavaScriptEnabled(true); 
     mywebview.loadUrl("http://www.facebook.com");
       } 
     }