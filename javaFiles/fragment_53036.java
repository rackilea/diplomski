Document = Jsoup.connect(yourUrl).get();
Elements elements = document.select(".OverRiddenClass");
for (Element element : elements) {
  String text = element.text();
  // further processing
}