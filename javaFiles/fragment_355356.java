String html = "<span style=\"font-weight:bold;\">bold.</span><span></span><span><a>text</a></span>";
Document parsedDoc = Jsoup.parse(html);
Elements selects = parsedDoc.select("span");

for (Element span : selects) {
    List<Node> childNodes = span.childNodes();
    if (childNodes.size() > 0 && span.childNode(0).childNodes().size() == 0) {
        span.childNode(0).wrap("<p>");
    }
}