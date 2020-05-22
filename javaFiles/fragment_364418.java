public abstract class MyWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (Uri.parse(url).getHost().equals("www.mysite.com")) {
            // This is my web site, so do not override; let my WebView load the page
            return false;
        }

        launchExternalBrowser(url);            
        return true;
    }

    public abstract void launchExternalBrowser(String url);
}