String html = "<div id=\"intro\">"
        + "<h1 class=\"some class\">"
        + "<p id=\"some_id\">"
        +   "Some text 1"
        + "</p>"
        + "<p name=\"some_name\">"
        +   "Some text A"
        + "</p>"
        + "<p data>"
        +   "Some text B"
        + "</p>"
        +"<p>"
        +   "Some text 2"
        +"</p>"
        +"</div> ";

Document doc = Jsoup.parse(html);
Elements els = doc.select("p:not([^])");
for (Element el:els){
    System.out.println(el.text());
}