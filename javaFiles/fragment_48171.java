Map<String, List<String>> clubs_by_country = new HashMap<String, List<String>>();
URL url = new URL("http://www.uefa.com/uefachampionsleague/season=2016/clubs/country/index.html");
Document doc = Jsoup.parse(url, 3000);
//class for all different countries
Elements elements = doc.select("div.contcountry.generalcont");
for(Element element : elements){
    //scrape the country name
    String country = element.select("h3").first().select("img").first().attr("title");
    Elements teams = element.select("tr[class~=(on|off)]");
    List<String> clubs = new LinkedList<String>();
    //scrape all club names
    for(Element team : teams){
        clubs.add(team.select("a").first().attr("title"));
    }
    clubs_by_country.put(country, clubs);
}