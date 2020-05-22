@Override
protected void onCreate(Bundle savedInstanceState) {
    // Get cookie manager for WebView
    // This must occur before setContentView() instantiates your WebView
    android.webkit.CookieSyncManager webCookieSync =
        CookieSyncManager.createInstance(this);
    android.webkit.CookieManager webCookieManager =
        CookieManager.getInstance();
    webCookieManager.setAcceptCookie(true);

    // Get cookie manager for HttpURLConnection
    java.net.CookieStore rawCookieStore = ((java.net.CookieManager)
        CookieHandler.getDefault()).getCookieStore();

    // Construct URI
    java.net.URI baseUri = null;
    try {
        baseUri = new URI("http://www.example.com");
    } catch (URISyntaxException e) {
        // Handle invalid URI
        ...
    }

    // Copy cookies from HttpURLConnection to WebView
    List<HttpCookie> cookies = rawCookieStore.get(baseUri);
    String url = baseUri.toString();
    for (HttpCookie cookie : cookies) {
        String setCookie = new StringBuilder(cookie.toString())
            .append("; domain=").append(cookie.getDomain())
            .append("; path=").append(cookie.getPath())
            .toString();
        webCookieManager.setCookie(url, setCookie);
    }

   //TODO:Your Code
}