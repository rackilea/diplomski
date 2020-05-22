public static DocumentBuilder createDocumentBuilder() {
    try {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
        return documentBuilderFactory.newDocumentBuilder();
    } catch (ParserConfigurationException var1) {
        throw new IllegalStateException(var1);
    }
}