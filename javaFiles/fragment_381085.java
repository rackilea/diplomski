URL url = new URL("http://example.com/");
Document doc = Jsoup.parse(url, 3*1000);
Elements links = doc.select("a[href]"); // a with href
for (Element link : links) {
   System.out.println("Href = "+link.attr("abs:href"));
}