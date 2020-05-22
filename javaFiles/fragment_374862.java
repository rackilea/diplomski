String url = "http://www.portal.pwr.wroc.pl/box_main_page_news,241.dhtml?limit=10";
String baseURL = "http://www.portal.pwr.wroc.pl/";
Document doc = Jsoup.connect(url).get();
Elements links = doc.select(".title_1 > a");
for (Element link : links) {
    System.out.println("Title - " + link.text());
    System.out.println(baseURL + link.attr("href"));
}