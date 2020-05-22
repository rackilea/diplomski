Document doc = Jsoup.parse("test.html");
Elements metaTags = doc.getElementsByTag("meta");

Example ex = new Example();

for (Element metaTag : metaTags) {
  String content = metaTag.attr("content");
  String name = metaTag.attr("name");

  if("d.title".equals(name)) {
    ex.setTitle(content);
  }
  if("d.description".equals(name)) {
    ex.setDescription(content);
  }
  if("d.language".equals(name)) {
    ex.setLanguage(content);
  }
}