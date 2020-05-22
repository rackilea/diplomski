Response response = Jsoup.connect("http://example.com/login")
    .method(Method.POST)
    .data("username", username)
    .data("password", password)
    .data("login", "Login")
    .execute();
Map<String, String> cookies = response.cookies();
Document document = response.parse(); // If necessary.
// ...