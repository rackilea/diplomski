private Map<String, String> cookies = new HashMap<String, String>();

public Document get(url) throws IOException {
    Connection connection = Jsoup.connect(url);
    for (Entry<String, String> cookie : cookies.entrySet()) {
        connection.cookie(cookie.getKey(), cookie.getValue());
    }
    Response response = connection.execute();
    cookies.putAll(response.cookies());
    return response.parse();
}