public static void main(String[] args) throws IOException {
    String str = "<div>" +
            "    Some text <b>with tags</b> might go here." +
            "    <p>Also there are paragraphs</p>" +
            "    More text can go without paragraphs<br/>" +
            "</div>";

    Document doc = Jsoup.parse(str);
    Element div = doc.select("div").first();
    int i = 0;

    for (Node node : div.childNodes()) {
        i++;
        System.out.println(String.format("%d %s %s",
                i,
                node.getClass().getSimpleName(),
                node.toString()));
    }
}