String html = "<font>fsdfs<font>dfsdf</font>dasdasd</font>";
Document doc = Jsoup.parse(html);
Elements elements = doc.select("font");


// rename all 'font'-tags to 'span'-tags, will also keep attributs etc.
elements.tagName("span");

System.out.println(doc.html());