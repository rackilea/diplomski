Connection.Response loginForm = Jsoup.connect(url)
            .method(Connection.Method.GET)
            .execute();

    Connection.Response mainPage = Jsoup.connect(login-validation-url)
            .data("user", user)
            .data("senha", password)
            .cookies(loginForm.cookies())
            .execute();

    Map<String, String> cookies = mainPage.cookies();

    Document evaluationPage = Jsoup.connect(login-required-url)
            .cookies(cookies)
            .execute.parse();

   return evaluationPage;