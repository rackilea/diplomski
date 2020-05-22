Response res = Jsoup
    .connect("loginPage.com/login.php")
    .data("username", "myUserName", "password", "myPass")
    .method(Method.POST)
    .execute();

 //This will get you cookies
 Map<String, String> loginCookies = res.cookies();