protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cadastro);
    wv = (WebView) findViewById(R.id.webView_cadastro);
    WebSettings settings = wv.getSettings();
    settings.setJavaScriptEnabled(true);
    settings.setDomStorageEnabled(true);
    wv.requestFocusFromTouch();
    wv.setWebChromeClient(new WebChromeClient());
    wv.loadUrl("https://onneti.net/melleven/cad.html");


    progressDialog = ProgressDialog.show(this, "", "Carregando formulário de cadastro , aguarde...");
    wv.setWebViewClient(new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String urlinterna) {

            urlEmCurso = urlinterna;
            if (urlEmCurso.contains("noSession")) {
               finish();
               startActivity(getIntent());
            }
           else {view.loadUrl(url); // Stay within this webview and load url
                      return true;}}});
        }

        @Override
        public void onPageFinished(WebView view, String url){
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }
            super.onPageFinished(view, url);
        }

    });