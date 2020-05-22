//The line you already had
Document doc = Jsoup.parse(feedXMLString);

//This will get you all the titles
Elements elems = doc.select("title");

//And now you can proceed in various ways:
String title1stWay = elems.first().text();
String title2ndWay = elems.get(0).text();