public static Map<String, String> transformXmlToMap(String xml) {
    Document doc = null;
    try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(false);
        DocumentBuilder bldr = factory
                .newDocumentBuilder();

        doc = bldr.parse(new ByteArrayInputStream(xml.getBytes()));
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }

    Map<String, String> map = new HashMap<String, String>();
    NamedNodeMap attributeMap = doc.getDocumentElement().getAttributes();

    for (int i = 0; i < attributeMap.getLength(); ++i) {
        Attr n = (Attr) attributeMap.item(i);

        map.put(n.getName(), n.getValue());
    }

    return map;
}