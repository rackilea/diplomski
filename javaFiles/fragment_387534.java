String url = "http://stackoverflow.com/questions/7377316/how-to-search-for-elements-where-specified-attribute-doesnt-exist-in-jsoup";
Document doc = Jsoup.connect(url).get();
//Select all divs without id
Elements divsWithoutid = doc.select("div:not([id])");
for (Element e : divsWithoutid) {
    //See ma, no id
    System.out.println("id = " + e.attr("id"));
}