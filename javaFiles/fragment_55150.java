Document doc = Jsoup.parse(data);
Elements elements = doc.select("a");
for(Element element: elements){
     String href = element.attr("href");
     data = data.replace(href, "abc.html");
}