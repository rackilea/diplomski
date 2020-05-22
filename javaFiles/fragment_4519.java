//Try this other url
    Connection.Response response = Jsoup.connect("https://www.lib.uts.edu.au/cas?destination=dashboard&cas_load_iframe=1")
            .timeout(300000)
            .userAgent("Mozilla/5.0")
            .method(Connection.Method.GET).execute();

    System.out.println("JSESSIONID=" + response.cookies().get("JSESSIONID"));
    System.out.println("SSESS012...=" + response.cookies().get("SSESS012ea49d58f199a67a953e1500684490"));