public static void main(String[] args) throws ParserConfigurationException,
        SAXException, IOException {

    DefaultHandler defaultHandler = new DefaultHandler() {
        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            //This method receives the entity as is
            System.out.println(new String(ch, start, length));
        }
    };

    XMLFilter xmlFilter = new XMLFilterEntityImpl(XMLReaderFactory.createXMLReader());
    xmlFilter.setContentHandler(defaultHandler);
    String xml = "<html><head><title>title</title></head><body>&amp;</body></html>";
    xmlFilter.parse(new InputSource(new StringReader(xml)));
}