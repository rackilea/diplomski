Document doc = Jsoup.connect("url").get();
Elements divs = doc.select("div");

for (Element div : divs) {
        String linkHref = div.attr("name"); 
    Elements links = div.select("a[href]");
}