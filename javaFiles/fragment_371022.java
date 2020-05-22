webView.setWebViewClient(new WebViewClient() {
    @Override
    public void onPageFinished(WebView view, String url) {
        // Pause is needed for my physical phone S7. In Emulator there I have no problem.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        view.scrollTo(0,0);
        super.onPageFinished(view, url);
    }
});