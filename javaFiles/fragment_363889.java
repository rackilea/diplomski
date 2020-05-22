private static DocumentBuilderFactory dbf;

public static void main(String[] args) {
    dbf = DocumentBuilderFactory.newInstance();
    dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
    dbf.setFeature("http://xml.org/sax/features/validation", false);
    ...
}

private static Document parseXML(URL url) throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse((url).openStream());
    doc.getDocumentElement().normalize();
    return doc;
}