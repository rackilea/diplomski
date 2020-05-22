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
    String html = IOUtils.toString(is, "UTF-8")

    // Parse html
    Document doc = Jsoup.parse(html, searchURL);
} catch(IOException e) {
    // Handle exception ...
} finally {
    IOUtils.closeQuietly(is);
}