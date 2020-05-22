public static void parseURL(String url) throws IOException {
    Document doc = Jsoup.connect(url)
            .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:26.0) Gecko/20100101 Firefox/26.0")
            .get();
    System.out.println(doc.toString());
}