public static void main(String[] args) {
    String html = "<html><head/><body><div class=\"main-content\">" +
            "<div class=\"sub-content\">" +
            "<p>a paragraph <b>with some bold text</b></p>" +
            "Sub content here</div>" +
            "Main content here </div></body></html>";
    Document document = Jsoup.parse(html);
    Elements divs = document.select("div, p, b");
    for (Element div : divs) {
        System.out.println(div.ownText());
    }
}