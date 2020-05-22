private String generateXmlContent(Map<String, List<String>> elementMap) {
    String content;

    Document doc = build(elementMap);
    DOMImplementation impl = doc.getImplementation();
    DOMImplementationLS implLS = (DOMImplementationLS) impl.getFeature("LS", "3.0");

    LSSerializer ser = implLS.createLSSerializer();
    ser.getDomConfig().setParameter("format-pretty-print", true);
    content = ser.writeToString(doc);

    return content;
}