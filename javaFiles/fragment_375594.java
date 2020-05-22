public class ReadWebpageAsyncTask extends Activity implements OnClickListener{

    private WebView browser;
    protected String urlStrOne = "url one";
    protected String urlNewCourses = "url two";
    protected String urlFutureCourses = "url three";
    Button reload, exit, soon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_webpage_async_task);
        browser = (WebView)findViewById(R.id.WebView01);
        browser.setWebViewClient(new MyBrowser());
        browser.loadUrl(urlStrOne);

        reload = (Button)findViewById(R.id.readWebpage);
        exit = (Button)findViewById(R.id.exitapp01);
        soon = (Button)findViewById(R.id.soon);

        reload.setOnClickListener(this);
        exit.setOnClickListener(this);
        soon.setOnClickListener(this);
    }


    @SuppressLint("SetJavaScriptEnabled")
    public void onClick(View view){

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()) {

            case R.id.readWebpage:
                browser.getSettings().setLoadsImagesAutomatically(true);
                browser.getSettings().setJavaScriptEnabled(true);
                browser.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                browser.loadUrl(urlStrOne);
                break;
            case R.id.exitapp01:
                //Do whatever you want with this button
                break;
            case R.id.soon:
                //Do whatever you want with this button
                break;

        }
    }
}