private void parseRdlFile(String filePath) {
    File rdlFile = new File(filePath);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder;
    Document doc;
    try {
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(rdlFile);
        System.out.println("Root:" + doc.getDocumentElement().getNodeName());
    } catch (SAXException | IOException | ParserConfigurationException e) {
        LOG.error("Error parsing", e);
    }
}