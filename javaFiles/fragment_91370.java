String testString ="<div><p><p>text1</p></p><p>text2</p></div>";

Document document = Jsoup.parse(testString,"",Parser.xmlParser());
System.out.println(document);
Element div = document.select("div").first();
Elements divChildren = div.children();
System.out.println(divChildren.size());