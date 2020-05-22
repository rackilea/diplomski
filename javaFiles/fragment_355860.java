// Handle XML SAX parser events.
private ContentHandler contentHandler = new ContentHandler() {
    public void startDocument() throws SAXException {...}

    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        cdata.setLength(0);
        if(atts == null) return;            
        // Write out attributes as new rows
        for(int i = 0; i < atts.getLength(); i++) {
            System.out.println(atts.getLocalName(i) + ": " + atts.getValue(i));
        }
    }


    public void characters(char[] ch, int start, int length) throws SAXException {...}

    public void endElement(String uri, String localName, String qName) throws SAXException {...}

    // All other events are ignored
    public void endDocument() throws SAXException {}
    public void endPrefixMapping(String prefix) throws SAXException {}
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {}
    public void processingInstruction(String target, String data) throws SAXException {}
    public void setDocumentLocator(Locator locator) {}
    public void skippedEntity(String name) throws SAXException {}
    public void startPrefixMapping(String prefix, String uri) throws SAXException {}
};