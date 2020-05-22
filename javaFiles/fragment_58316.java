RelativeLayout layout = new RelativeLayout(this); // Use LinearLayout instead of Relative

glView = new GLSurfaceView(this);
glView.setRenderer(this);
glView.setZOrderMediaOverlay(false);
glView.setId(123); // set id

RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(640, 480);
layout.addView(glView, params);

webView = new WebView(this);
this.showWV(false); //handler message , i hide it in certain screen.
webView.getSettings().setJavaScriptEnabled(true);
webView.getSettings().setLoadWithOverviewMode(true);
webView.getSettings().setUseWideViewPort(true);

params = new RelativeLayout.LayoutParams(640, 480);
params.addRule(RelativeLayout.BELOW, glView.getId()); // set WebView position is below GLSurfaceView
layout.addView(webView, params);

webView.loadUrl("http://stackoverflow.com");

setContentView(layout);