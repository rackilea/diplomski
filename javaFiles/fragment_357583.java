public static void main(String[] args) {
    String html = "<html><head/><body><div class=\"main-content\">" +
            "<div class=\"sub-content\">Sub content here</div>" +
            "Main content here </div></body></html>";
    Document document = Jsoup.parse(html);
    Elements divs = document.select("div");
    for (Element div : divs) {
        System.out.println(div.ownText());
    }
}