try {
    Connection.Response response = Jsoup.connect("https://app.northpass.com/login")
            .method(Connection.Method.GET)
            .execute();

    //I can't test this but will be something like
    //see https://jsoup.org/cookbook/extracting-data/selector-syntax
    Document document = response.parse();
    String token = document.select("input[hidden]").first().val();

    response = Jsoup.connect("https://app.northpass.com/login")
            .data("educator[email]", "email123")
            .data("educator[password]", "password123")
            .data("authenticity_token", token)
            .cookies(response.cookies())
            .method(Connection.Method.POST)
            .execute();

    // Go to new page
    Document coursePage = Jsoup.connect("https://app.northpass.com/course")
            .cookies(response.cookies())
            .get();

    System.out.println(groupPage.title());

} catch (IOException e) {
    e.printStackTrace();
}