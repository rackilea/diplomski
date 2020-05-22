webView.setWebViewClient(new WebViewClient() {
    @Override
    public boolean shouldOverrideUrlLoading(WebView wv, String url) {
        if (url.startsWith("tel:")) { 
            Intent intent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse(url)); 
            startActivity(intent); 

            return true; // we handled the url loading
        }

        return false; // let WebView handle this event
    }
});