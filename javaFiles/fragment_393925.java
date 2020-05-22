final String js = "javascript:document.getElementById('j_password').value='something';";
webView.setWebViewClient(new WebViewClient() {
    @Override
    public void onPageFinished(WebView view, String url) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.evaluateJavascript(js, new ValueCallback<String>() {
                @Override
                public void onReceiveValue(String s) { }
            });
        } else {
            view.loadUrl(js);
        }
     }
});