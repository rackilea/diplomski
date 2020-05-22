webview.setWebViewClient(new WebViewClient(){
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url != null) {
            view.getContext().startActivity(
                new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            return true;
        } else {
            return false;
        }
    }
});

webview.loadUrl("http://www.stitcher.com/podcast/entrepreneuronfirecom/entrepreneur-on-fire-tim-ferriss-other-incredible-entrepreneurs");