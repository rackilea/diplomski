String html = "<p>Para one</p><p>Para <b>two keyword</b></p>";
Document doc = Jsoup.parse(html);

Element el = doc.select(":containsOwn(keyword)").first();
Element p = doc.select("p:contains(keyword)").first();

System.out.println(el.html());
System.out.println(p.html());