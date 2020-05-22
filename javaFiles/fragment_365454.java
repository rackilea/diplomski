String url = "https://www.aboutyou.de/frauen/accessoires/huete-und-muetzen/caps";
String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36";

try {
    Document doc = Jsoup.connect(url).userAgent(userAgent).get();
    Elements elements = doc.select("div[class^='categoryTileWrapper_']");

    for (Element element : elements) {

        String brand = element.select("strong[class^='brand_']").first().text();
        String name = element.select("p[class^='name_']").first().text();
        System.out.println(brand + " - " + name);

        String href = element.select("a[class^='anchor_']").first().absUrl("href");
        Document subDoc = Jsoup.connect(href).userAgent(userAgent).get();
        String color = subDoc.select("div[class^='attributeWrapper_']").first().text();     
        System.out.println("\t"+href);
        System.out.println("\t"+color);

        String finalPrice = element.select("div[class^='finalPrice_']").first().text();

        if( element.select("ul").size()>0 ){
            for (Element listItems : element.select("ul").first().select("li")) {
                System.out.println("\tpriece was: " + listItems.select("span[class^='price_']").first().text());
            }
        }
        System.out.println("\tfinal priece: " + finalPrice);
    }
} catch (IOException e) {
    e.printStackTrace();
}