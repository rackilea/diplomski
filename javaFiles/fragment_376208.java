blizzView.setWebViewClient(new WebViewClient() {      //
    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);

        backButton = findViewById(R.id.backButton);
        backButton.setEnabled(blizzView.canGoBack());

        if (blizzView.canGoBack()) {
            backButton.setVisibility(View.VISIBLE);
        } else {
            backButton.setVisibility(View.INVISIBLE);
        }

    }
});