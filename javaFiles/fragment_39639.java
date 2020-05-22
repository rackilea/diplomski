String url = "https://www.sherdog.com/news/rankings/2/Sherdogs-Official-Mixed-Martial-Arts-Rankings-164999";
Document document = Jsoup.connect(url).get();
Elements fighters = document.select("h2 > a[href]");
for (Element fighter : fighters) {
    System.out.println(fighter.text());
    String fighterUrl = "https://www.sherdog.com" + fighter.attr("href"); 
    Document doc = Jsoup.connect(fighterUrl).get();
    Element fighterData = doc.select("div.data").first();
    System.out.println(fighterData.text());
    System.out.println("---------------");
}