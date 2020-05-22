InputStream is = null;

try {
    // Connect to website
    URL tmp = new URL(url);
    HttpURLConnection connection = (HttpURLConnection) tmp.openConnection();
    connection.setReadTimeout(10000);
    connection.setConnectTimeout(10000);
    connection.setRequestMethod("GET");
    connection.connect();

    // Load content for Jsoup
    is = connection.getInputStream(); // We suppose connection.getResponseCode() == 200

    int n;
    char[] buffer = new char[4096];
    Reader r = new InputStreamReader(is, "UTF-8");
    Writer w = new StringBuilderWriter();
    while (-1 != (n = r.read(buffer))) {
        w.write(buffer, 0, n);
    }

    // Parse html
    String html = w.toString();
    Document doc = Jsoup.parse(html, searchURL);
} catch(IOException e) {
    // Handle exception ...
} finally {
    try {
        if (is != null) {
            is.close();
        }
    } catch (final IOException ioe) {
        // ignore
    }
}