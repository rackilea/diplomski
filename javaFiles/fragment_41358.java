private void uiBind() {
    webView = (WebView) findViewById(R.id.web_view);
    webView.setWebViewClient(new FileWebView());
    webView.getSettings().setLoadsImagesAutomatically(true);
    webView.getSettings().setJavaScriptEnabled(true);
    webView.getSettings().setAllowFileAccess(true);

    if (mode == Constant.PDF_FILE) {
        webView.loadUrl("http://docs.google.com/gview?embedded=true&url="
                + "http://www.5gamericas.org/files/2714/1471/2645/4G_Americas_Recommendations_on_5G_Requirements_and_Solutions_10_14_2014-FINALx.pdf");

    } else if (mode == Constant.DOC_FILE) {
        webView.loadUrl("http://docs.google.com/gview?embedded=true&url="
                + "http://ijsetr.com/uploads/4256135G%20Mobile%20Wireless%20Technology.docx");

    } else if (mode == Constant.EXCEL_FILE) {
        webView.loadUrl("http://docs.google.com/gview?embedded=true&url="
                + "http://download.microsoft.com/download/1/4/E/14EDED28-6C58-4055-A65C-23B4DA81C4DE/Financial%20Sample.xlsx");
    }
}

public class FileWebView extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        // TODO Auto-generated method stub
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        // TODO Auto-generated method stub
        super.onPageFinished(view, url);

    }
}