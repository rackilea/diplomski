WebViewClient client = new MyWebViewClient() {
    @Override
    public void launchExternalBrowser(String url) {
         Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
         startActivity(intent);
    }
};