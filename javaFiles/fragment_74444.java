private class MyWebviewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webProgress.setVisibility(View.VISIBLE);
            return super.shouldOverrideUrlLoading(view, url);
    }

        @Override
        public void onPageFinished(WebView view, String url) {
            webProgress.setVisibility(View.GONE);
        }

}