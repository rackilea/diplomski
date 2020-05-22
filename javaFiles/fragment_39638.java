String url = "https://www.sherdog.com/news/rankings/2/Sherdogs-Official-Mixed-Martial-Arts-Rankings-164999";
Document document = Jsoup.connect(url).get();
Elements fighters = document.select("h2 > a[href]");
for (Element fighter : fighters) {
     System.out.println(fighter.text() + " " + fighter.attr("href"));
}