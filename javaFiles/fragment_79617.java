webView.setWebChromeClient(new WebChromeClient() {
public void onProgressChanged(WebView view, int progress) {
    progressBar.setProgress(progress);
    if (progress == 100) {
        progressBar.setVisibility(View.GONE);

    } else {
        progressBar.setVisibility(View.VISIBLE);

    }
 }
});