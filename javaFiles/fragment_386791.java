NodeList list = document.getDocumentElement().getElementsByTagName("string");
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty("omit-xml-declaration", "yes");
    for (int i = 0; i < list.getLength(); i++) {
        Node node = list.item(i);
        Node child = node.getFirstChild();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(child), new StreamResult(writer));
        System.out.println(writer.toString());  // Do your list thing in stead
    }