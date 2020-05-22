String html = getTheHTMLSomeWay();

Document doc = Jsoup.parse(Jsoup.clean(html, "http://base.uri", Whitelist.relaxed().preserveRelativeLinks(true)));
doc.outputSettings().escapeMode(EscapeMode.xhtml).syntax(Syntax.xml).charset(StandardCharsets.UTF_8);

org.w3c.dom.Document document = $(doc.html()).document();

System.out.println($(document).find("a[href='/your/relative/url']"));