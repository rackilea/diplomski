@Test
public void testParser() throws Exception {
    // Initialize SAX components
    Long startTime = System.currentTimeMillis();

    SAXParserFactory spf = SAXParserFactory.newInstance();
    SAXParser saxParser = spf.newSAXParser();
    File f = new File("/home/grigory/test.svg");
    saxParser.parse(new FileInputStream(f), new MyHandler());
    System.out.println("execution time: " + (System.currentTimeMillis() - startTime));
}

private static class MyHandler extends DefaultHandler {

    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws IOException, SAXException {
        System.out.println("resolve: "+ systemId);
        InputStream is = new FileInputStream("/home/grigory/svg10.dtd");
        return new InputSource(is);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("start element '" + qName + "'");
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println(e.getMessage());
        super.warning(e);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println(e.getMessage());
        super.error(e);
    }
}