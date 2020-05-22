Document doc = Jsoup.parseBodyFragment("<p class=\"baz\">foo</p> <p>bar</p>");
Elements paragraphs = doc.getElementsByTag("p");

if (paragraphs.size() > 0) {
  System.out.println(paragraphs.get(0).text());
}