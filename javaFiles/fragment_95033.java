Map<String, String> cookies = new HashMap<String, String>();

// First request.
Connection connection1 = Jsoup.connect(url1);
for (Entry<String, String> cookie : cookies.entrySet()) {
    connection1.cookie(cookie.getKey(), cookie.getValue());
}
Response response1 = connection1.execute();
cookies.putAll(response1.cookies());
Document document1 = response1.parse();
// ...

// Second request.
Connection connection2 = Jsoup.connect(url2);
for (Entry<String, String> cookie : cookies.entrySet()) {
    connection2.cookie(cookie.getKey(), cookie.getValue());
}
Response response2 = connection2.execute();
cookies.putAll(response2.cookies());
Document document2 = response2.parse();
// ...

// Third request.
Connection connection3 = Jsoup.connect(url3);
for (Entry<String, String> cookie : cookies.entrySet()) {
    connection3.cookie(cookie.getKey(), cookie.getValue());
}
Response response3 = connection3.execute();
cookies.putAll(response3.cookies());
Document document3 = response3.parse();
// ...

// Etc.