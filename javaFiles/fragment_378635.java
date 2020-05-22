List<String> href = new ArrayList<>();
// Considering that text is a String variable that contains the html
final Document document = Jsoup.parse(text);
for (Element element : document.select("link")) {
    href.add(element.attr("href"));
}
// In this point the list href will have all the links