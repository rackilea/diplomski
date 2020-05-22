if (webView == null) {
      webView = new WebView(this);
      webView.setVisibility(View.INVISIBLE);
      webView.getSettings().setJavaScriptEnabled(true);
      webView.addJavascriptInterface(new JavascriptCheck(this), "Android");
      webView.setWebViewClient(new WebViewClient() {
          public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
               Toast.makeText(this, "Streetview loading", Toast.LENGTH_SHORT).show();
               super.onReceivedError(view, errorCode, description, failingUrl);
                }
      });
    }

    Toast.makeText(this, "Streetview loading", Toast.LENGTH_SHORT).show();

    webView.loadDataWithBaseURL(baseurl, 
      getString(R.string.html_streetview, latitude, longitude), "text/html", "UTF-8", baseurl);