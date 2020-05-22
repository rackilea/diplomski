HttpURLConnection urlConnection = null;
try {
    urlConnection = (HttpURLConnection) url.openConnection();

    // Fetch and set cookies in requests
    CookieManager cookieManager = CookieManager.getInstance();
    String cookie = cookieManager.getCookie(urlConnection.getURL().toString());
    if (cookie != null) {
        urlConnection.setRequestProperty("Cookie", cookie);
    }
    urlConnection.connect();

    // Get cookies from responses and save into the cookie manager
    List cookieList = urlConnection.getHeaderFields().get("Set-Cookie");
    if (cookieList != null) {
        for (String cookieTemp : cookieList) {
            cookieManager.setCookie(urlConnection.getURL().toString(), cookieTemp);
        }
    }

    InputStream in = new BufferedInputStream (urlConnection.getInputStream());
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (urlConnection != null) {
        urlConnection.disconnect();
    }
}