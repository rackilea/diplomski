Connection.Response response = Jsoup.connect(url).method(Connection.Method.GET).execute();

        response = Jsoup.connect(url)
                .cookies(response.cookies())
                .data("Action", "Login")
                .data("User", "My_UserName")
                .data("Password", "My_Password")
                .method(Connection.Method.POST)
                .followRedirects(true)
                .timeout(50000)
                .execute();