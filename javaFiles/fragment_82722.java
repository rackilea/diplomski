loginResponse = Jsoup.connect("http://www.pastebin.com/login.php")
        .data("submit_hidden", "submit_hidden")
        .data("user_name", name)
        .data("user_password", pwrd)
        .data("submit", "Login")
        .cookies(loginResponse.cookies()) // pass cookies
        .method(Method.POST)
        .execute();