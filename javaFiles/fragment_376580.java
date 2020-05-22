SAXParser p = SAXParserFactory.newInstance().newSAXParser();
    XMLReader filter = new XMLFilterImpl(p.getXMLReader()) {
        private boolean inFunctions;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
            if (!inFunctions && qName.equals("Functions")) {
                inFunctions = true;
            }
            if (inFunctions) {
                super.startElement(uri, localName, qName, atts);
            } else {
                qName.equals("Functions");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (inFunctions) {
                super.endElement(uri, localName, qName);
                if (qName.equals("Functions")) {
                    inFunctions = false;
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (inFunctions) {
                super.characters(ch, start, length);
            }
        }
    };
    Transformer t = TransformerFactory.newInstance().newTransformer();
    Source source = new SAXSource(filter, new InputSource(new FileInputStream("1.xml")));
    Result result = new StreamResult(System.out);
    t.transform(source, result);
}