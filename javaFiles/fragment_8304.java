Display display = getWindowManager().getDefaultDisplay();
int width=display.getWidth();

String data="<html><head><title>Example</title><meta name=\"viewport\"\"content=\"width="+width+", initial-scale=0.65 \" /></head>";
data=data+"<body><center><img width=\""+width+"\" src=\""+url+"\" /></center></body></html>";
webView.loadData(data, "text/html", null);