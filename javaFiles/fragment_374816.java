String result = getStringFromInputStream(is);

Document doc = Jsoup.parse(result, "", Parser.xmlParser());
Element e = doc.getElementsByTag("app").first();

System.out.println(e.attr("hash"));
System.out.println(e.attr("name"));

//etc...