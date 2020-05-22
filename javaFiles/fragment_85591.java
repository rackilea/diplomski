myWebView.post(new Runnable() {
    @Override
    public void run() {
        myWebView.loadUrl("https://www.google.com");
    }
});