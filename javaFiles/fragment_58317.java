RelativeLayout layout = new RelativeLayout(this); // Use LinearLayout instead of Relative

// create a fake view with zero size and place it to center of RelativeLayout
View fakeView = new View(this); 
fakeView.setId(24736); 
RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0, 0);
params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
layout.addView(fakeView, params);

glView = new GLSurfaceView(this);
glView.setRenderer(this);
glView.setZOrderMediaOverlay(false);
glView.setId(123); // set id

params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
params.addRule(RelativeLayout.ABOVE, fakeView.getId()); // set position is above fakeView
layout.addView(glView, params);

webView = new WebView(this);
this.showWV(false); //handler message , i hide it in certain screen.
webView.getSettings().setJavaScriptEnabled(true);
webView.getSettings().setLoadWithOverviewMode(true);
webView.getSettings().setUseWideViewPort(true);

params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
params.addRule(RelativeLayout.BELOW, fakeView.getId()); // set WebView position is below fakeView
layout.addView(webView, params);

webView.loadUrl("http://stackoverflow.com");

setContentView(layout);