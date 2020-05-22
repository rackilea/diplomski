String username = "foo";
String password = "bar";
String login = username + ":" + password;
String base64login = new String(Base64.encodeBase64(login.getBytes()));

Document document = Jsoup
    .connect("http://example.com")
    .header("Authorization", "Basic " + base64login)
    .get();

// ...