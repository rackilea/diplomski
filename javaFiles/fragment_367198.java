public class MainActivity extends AppCompatActivity
{
    private WebView webView;

   public void onCreate(Bundle savedInstanceState){
    // you code to set content view
    webView = (WebView) findViewById(R.id.webview);        
    webView.postUrl(url, postData.getBytes());
    registerReceiver(new ConnectionBroadReceiver(new NetworkCallback(){
          @Override
          public void onStateChange(){
               webview.reload();
          }
     }),new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")); 
  }
}