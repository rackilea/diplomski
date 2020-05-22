Document doc = Jsoup.parse(html);

Elements elements = doc.select("li.location");
for (int i = 0; i < elements.size(); i++) {
    System.out.println(elements.get(i).text());
}