protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

      myBrowser = (WebView)findViewById(R.id.webView1);

      //Browser settings
      WebSettings myBrowserSettings = myBrowser.getSettings();

      //Delete previously stored cookies and disable cookies
      CookieSyncManager.createInstance(this);
      CookieManager cookieManager = CookieManager.getInstance();
      cookieManager.removeAllCookie();
      cookieManager.setAcceptCookie(false);

      //Prevent cache to be used
      myBrowserSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
      myBrowserSettings.setAppCacheEnabled(false);

      //General settings
      myBrowserSettings.setSaveFormData(false);
      myBrowserSettings.setLoadsImagesAutomatically(true);
      myBrowserSettings.setJavaScriptEnabled(true);

      //FIREFOX 
      myBrowserSettings.setUserAgentString("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0");

      myBrowserSettings.setUseWideViewPort(true);
      myBrowserSettings.setLoadWithOverviewMode(true);
      myBrowserSettings.setBuiltInZoomControls(true); 
      myBrowserSettings.setLightTouchEnabled(false);
      myBrowserSettings.setPluginState(PluginState.ON);

      //Open the browser
      myBrowser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);     
      myBrowser.loadUrl(urlToBrowse);
      myBrowser.setWebViewClient(new WebViewClient() {
          public void onPageFinished(WebView view, String url) 
          {
              String word = "My Keyword";

              view.loadUrl("javascript:document.getElementById('gbqfq').value = '"+word+"';");  
              view.loadUrl("javascript:document.getElementById('gbqfba').click();");  
          }
      });