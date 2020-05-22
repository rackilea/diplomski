private static final java.net.URL STATIC_URL = makeUrl("http://www.example.com");

public static java.net.URL makeUrl(String urlString) {
    try {
        return new java.net.URL(urlString);
    } catch (java.net.MalformedURLException e) {
        return null; //Or rethrow an unchecked exception
    }
}