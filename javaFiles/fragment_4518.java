//This url loads the login form
    Connection.Response response = Jsoup.connect("https://www.lib.uts.edu.au/auth/login?service=https%3A%2F%2Fwww.lib.uts.edu.au%2Fcas%3Fcas_load_iframe%3D1%26destination%3Ddashboard&iframe=true")
            .timeout(300000)
            .userAgent("Mozilla/5.0")
            .method(Connection.Method.GET).execute();

    System.out.println("JSESSIONID=" + response.cookies().get("JSESSIONID"));