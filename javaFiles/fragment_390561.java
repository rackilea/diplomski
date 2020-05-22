public static void main(String[] args) throws Exception {
    String html = new String(Files.readAllBytes(Paths.get("input.html")));
    Document doc = Jsoup.parse(html);
    Element content = doc.select("div").first();

    Element lastValidElement = content.select("p:contains(efg)").first();
    int lastValidElementIndex = content.children().indexOf(lastValidElement);
    content.getElementsByIndexGreaterThan(lastValidElementIndex).remove();
    System.out.println(content);
}