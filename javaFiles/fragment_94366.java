try {
        String url = "www.website.com";
        Connection.Response response = Jsoup.connect(url).method(Connection.Method.GET).execute();

        response = Jsoup.connect(url)
                .cookies(response.cookies())
                .data("Action", "Login")
                .data("User", "your_login")
                .data("Password", "your_password")
                .method(Connection.Method.POST)
                .followRedirects(true)
                .execute();

        Document document = response.parse();
        System.out.println(document);

    } catch (IOException e) {
        e.printStackTrace();
    }