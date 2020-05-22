setContentView(R.layout.activity_main);

engine = (WebView) findViewById(R.id.web_engine); 

context = this;
WebSettings webSettings = engine.getSettings();
webSettings.setJavaScriptEnabled(true);

engine.setWebViewClient(new WebViewClient());
engine.loadUrl("file:///android_asset/" + page);

boolean javascriptInterfaceBroken = false;
try {
        if (Build.VERSION.RELEASE.startsWith("2.3")) {
         javascriptInterfaceBroken = true;
        }
    } catch (Exception e) {

    // Ignore, and assume user javascript interface is working correctly.
    }

// Add javascript interface only if it's not broken
    // @TODO: write the workaround for < 2.3 devices
if (!javascriptInterfaceBroken) {
        engine.addJavascriptInterface(new webViewInterface(), "MainActivityInterface");
}   

//disables text selection
engine.setOnLongClickListener(new View.OnLongClickListener() {
    public boolean onLongClick(View v) {
        return true;
    }
});     
}