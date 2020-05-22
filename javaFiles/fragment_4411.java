Document doc = Jsoup.connect("https://www.google.com/search?num=10&safe=off&tbm=nws&q=anime&oq=anime").userAgent("Mozilla").get();
Elements links = doc.select("li.g h3 a");
for (Element e: links) {
    System.out.println("Title: " + e.text());
    System.out.println("Link: " + e.attr("href"));
}