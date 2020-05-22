String xml = "<Address1><Street>This caused error coz street is not closed</Address1><Address2>This displayed normal</Address2>";
Document doc = Jsoup.parse(xml, "", Parser.xmlParser());
Elements elements = doc.getElementsByTag("Address1");
System.out.println(elements.first().text());
// it will print: "This caused error coz street is not closed"
Elements elements2 = doc.getElementsByTag("Address2");
System.out.println(elements2.first().text());
// it will print: "This displayed normal"