public static String getUrl(String search) throws IOException{

    Connection.Response wordForm = Jsoup.connect("http://wordnetweb.princeton.edu/perl/webwn")
            .method(Connection.Method.GET)
            .execute();

    String url = "http://wordnetweb.princeton.edu/perl/webwn";
    Document doc = Jsoup.connect(url)
            .data("s", search)
            .data("o2", "")
            .data("o0", "1")
            .data("o8", "1")
            .data("o1", "1")
            .data("o7", "")
            .data("o5", "")
            .data("o9", "")
            .data("o6", "")
            .data("o3", "")
            .data("o4", "")
            .data("h", "")
            .cookies(wordForm.cookies())
            .post();

    System.out.println(doc);

    String newURL = doc.location().toString();
    return (newURL);
}