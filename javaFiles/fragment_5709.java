Element contactHtml = null;
String person = "";
Document doc = Jsoup.parse(html);

Elements elements = doc.select("p.initial-contact");
if(!elements.isEmpty()) {
   contactHtml = elements.get(0);
   person = contactHtml.text();
}