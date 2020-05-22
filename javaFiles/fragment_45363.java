String html = 
    "<div class=\"abcdefghijk\">" +
        "<p>a</p><p>b</p><p>c</p><p>d</p><p>e</p>" + // get these
        "<p>f</p><p>h</p><p>i</p><p>j</p><p>k</p>" +
    "</div>";
Document doc = Jsoup.parse(html);
Elements paras = doc.select("div.abcdefghijk p");
for (Element el : paras.subList(0, Math.min(5, paras.size())) {
    System.out.println(el);
}