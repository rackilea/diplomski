String pdfLink = null;

Document doc = Jsoup.connect("http://www.dunnesstores.com/offer20/food-wine/fcp-category/home").get();
Elements links = doc.select("a[title=\"Download offers in store\"]");

for (Element link : links) {
    pdfLink = link.attr("abs:href");
}

System.out.println(pdfLink);