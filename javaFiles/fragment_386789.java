Document document = Jsoup.connect(url).get();
Elements rows = document.select("#amis_prices").select("tr:not(.labelLists)");
for (Element row : rows) {
    String name = row.select(".listItem").text();
    String maxPrice = row.select(".pricedata:nth-of-type(3)").text();
    System.out.println(name + ": " + maxPrice); // or what is appropriate in your code
}