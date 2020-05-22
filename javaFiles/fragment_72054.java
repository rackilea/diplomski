mywebview.setWebViewClient(new WebViewClient()) 
    private class MyWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
    return false;
        }