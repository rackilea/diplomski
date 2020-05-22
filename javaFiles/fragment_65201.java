public class Main2Activity extends Activity {
/** Called when the activity is first created. */

WebView myWebView;
ProgressBar progressBar;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);

    myWebView = (WebView) findViewById(R.id.webView);
    progressBar = (ProgressBar) findViewById(R.id.progressBar7);

    myWebView.setWebViewClient(new myWebClient(this));
    myWebView.getSettings().setJavaScriptEnabled(true);
    WebSettings webSettings = myWebView.getSettings();
    myWebView.loadUrl("https://docs.google.com/viewer?url=http%3A%2F%2Fpzstiz.swiebodzin.pl%2Fzastepstwa%2FPZSTiZ_zastepstwa.pdf");
    webSettings.setBuiltInZoomControls(true);
    webSettings.setSupportZoom(true);
    myWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
    myWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);

}

public class myWebClient extends WebViewClient
{

    privat Activity main2ac;
    ProgressBar progressBar;

    public myWebClient(Activity handle){
        main2ac = handle;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        // TODO Auto-generated method stub
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
    // TODO Auto-generated method stub

        if(progressBar == null)
            progressBar = (ProgressBar)main2ac.findViewById(R.id.progressBar7);
        if(progressBar)
            progressBar.setVisibility(View.VISIBLE);
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        // TODO Auto-generated method stub
        super.onPageFinished(view, url);

        if(progressBar == null)
            progressBar = (ProgressBar)main2ac.findViewById(R.id.progressBar7);
        if(progressBar)
            progressBar.setVisibility(View.GONE);
    }
}