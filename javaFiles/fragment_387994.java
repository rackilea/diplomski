private Document parseXMLStringWriter(StringWriter xmlStringWriter) throws ParserConfigurationException,
                                                                                        IOException, SAXException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    return builder.parse(new InputSource(new StringReader(xmlStringWriter.toString())));
}