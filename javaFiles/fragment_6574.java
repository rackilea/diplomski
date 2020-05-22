public static void main(String[] args) throws Exception {
    final String xml = "<root><foo><bar><baz name=\"phleem\" />"
                     + "<baz name=\"gumbo\" /></bar></foo></root>";

    Document document = DocumentHelper.parseText(xml);

    // simple collection views
    for (Element element : (List<Element>) document
            .getRootElement()
            .element("foo")
            .element("bar")
            .elements("baz")) {
        System.out.println(element.attributeValue("name"));
    }

    // and easy xpath support
    List<Element> elements2 = (List<Element>)
        document.createXPath("//baz").evaluate(document);
    for (final Element element : elements2) {
        System.out.println(element.attributeValue("name"));
    }
}