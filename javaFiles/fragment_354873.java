HttpClient httpclient = new DefaultHttpClient();
HttpPost httppost = new HttpPost(url);
String userAgent = "Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";

try {
    httppost.setHeader("User-Agent", userAgent);
    // Add your data

    // Execute HTTP Post Request
    HttpResponse response = httpclient.execute(httppost);
    // ....
} catch ... {