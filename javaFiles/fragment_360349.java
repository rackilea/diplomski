Elements elements = doc.select("li div.product-description");

for (Element element : elements) {

    String title = element.select("a.product-name").first().attr("title");  
    String img = element.select("img").first().attr("src");
    String href = element.select("a").first().attr("href"); 
    String priceNormal = element.select("span.product-price-normal").first().text();    
    String priceDiscount = element.select("span.product-price-discount").isEmpty() ? "-" : element.select("span.product-price-discount").first().text();    
    String priceDiscountPercent = element.select("div.product-discount").isEmpty() ? "0" : element.select("div.product-discount").first().text();

}