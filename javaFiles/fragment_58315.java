LinearLayout layout = new LinearLayout(this); // Use LinearLayout instead of Relative

glView = new GLSurfaceView(this);
glView.setRenderer(this);
glView.setZOrderMediaOverlay(false);

// height is 0, weight is 1
LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
layout.addView(glView, params);

webView = new WebView(this);
this.showWV(false); //handler message , i hide it in certain screen.
webView.getSettings().setJavaScriptEnabled(true);
webView.getSettings().setLoadWithOverviewMode(true);
webView.getSettings().setUseWideViewPort(true);

// height is 0, weight is 1
params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
layout.addView(webView, params);

webView.loadUrl("http://stackoverflow.com");

setContentView(layout);