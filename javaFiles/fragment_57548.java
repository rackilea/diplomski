String xml = "<Root>" +
               "<Item>" +
                 "<No>A123</No>" +
                 "<Other>Foo</Other>" +
                 "<Status>0</Status>" +
               "</Item>" +
               "<Item>" +
                 "<No>B456</No>" +
                 "<Other>Bar</Other>" +
                 "<Status>1</Status>" +
               "</Item>" +
               "<Item>" +
                 "<No>C789</No>" +
                 "<Other>Baz</Other>" +
                 "<Status>0</Status>" +
               "</Item>" +
             "</Root>";
Element root = DocumentBuilderFactory.newInstance().newDocumentBuilder()
               .parse(new InputSource(new StringReader(xml))).getDocumentElement();
NodeList items = root.getElementsByTagName("Item");
for (int i = 0; i < items.getLength(); i++) {
    Element item = (Element) items.item(i);
    if ("0".equals(item.getElementsByTagName("Status").item(0).getTextContent()))
        System.out.println(item.getElementsByTagName("No").item(0).getTextContent());
}