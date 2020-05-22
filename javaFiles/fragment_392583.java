public class Quotes extends Activity implements OnClickListener{

  private WebView webview;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    webview = (WebView) findViewById(R.id.scroll);
    webview.getSettings().setJavaScriptEnabled(true);
    webview.setWebViewClient(new MyWebViewClient(this));
    webview.loadUrl("http://www.dgdevelco.com/quotes/quotesandroid.html");

    findViewById(R.id.refresh).setOnClickListener(this);
  }


  public void onClick(View v){
       switch(v.getId()){
       case R.id.refresh:
            webview.reload();
             break;
            }
       }
  }