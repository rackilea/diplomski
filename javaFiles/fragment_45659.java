List<String> links = new ArrayList<String>();
Document doc = Jsoup.connect(url).get();
Elements links = doc.select("a[href]");
Elements media = doc.select("[src]");
Elements imports = doc.select("link[href]");
for (Element src : media) {
    links.add(src.attr("abs:src"));
}
for (Element link : imports) {
    links.add(link.attr("abs:href"));
}
for (Element link : links) {
    links.add(link.attr("abs:href"));
}