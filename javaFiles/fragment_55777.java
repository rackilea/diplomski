public static void main(String[] args) {
    Document doc = Jsoup.parse("<p>PageID: 2816; NS: 0; Title: some text; \r\nImage url: \r\nContent:\r\n{{Wort der Woche}}\r\n{{Siehe auch}}\r\n</p>\r\n<h2><span class=\"1\" id=\"e1\">some text</span></h2>\r\n<h3><span class=\"1\" id=\"e2\">some text</span></h3>\r\n\r\n<p>{{Transportation}}\r\n</p>\r\n<dl>\r\n    <dd>Flying</dd>\r\n    <dd>Driving</dd>\r\n    <dd>Sailing\r\n        <dl>\r\n            <dd>Boat</dd>\r\n            <dd>Ship</dd>\r\n        </dl>\r\n    </dd>\r\n</dl>\r\n\r\n<p>{{Activities}}\r\n</p>\r\n<dl>\r\n    <dd>Shopping</dd>\r\n    <dd>Painting</dd>\r\n</dl>");
    Elements e = doc.getElementsContainingOwnText("{{Transportation}}");
    Element nextDL = e.get(0).nextElementSibling();
    System.out.println(nextDL);
}