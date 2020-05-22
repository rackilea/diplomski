public static void parse() throws ParserConfigurationException, SAXException {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    factory.setValidating(true);
    SAXParser saxParser = factory.newSAXParser();
    File file = new File("test.xml");
    saxParser.parse(file, new ElementHandler());    // specify handler
}