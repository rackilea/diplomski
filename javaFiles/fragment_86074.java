public static void main(String... args) throws Exception {
    URL url = new URL("http://www.apple.com/pr/");
    Document document = Jsoup.parse(url, 3000);
    for (Element element : document.select("div#releases ul.stories a")) {
        System.out.println(element.attr("href"));
    }
}