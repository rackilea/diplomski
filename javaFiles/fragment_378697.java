XMLReader xr = new XMLFilterImpl(XMLReaderFactory.createXMLReader()) {
        private boolean skip;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes atts)
                throws SAXException {
            if (qName.equals("rule")) {
                if (atts.getValue("id").equals("1")) {
                    skip = true;
                } else {
                    super.startElement(uri, localName, qName, atts);
                    skip = false;
                }
            } else {
                if (!skip) {
                    super.startElement(uri, localName, qName, atts);
                }
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (!skip) {
                super.endElement(uri, localName, qName);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (!skip) {
                super.characters(ch, start, length);
            }
        }
    };
    Source src = new SAXSource(xr, new InputSource("test.xml"));
    Result res = new StreamResult(System.out);
    TransformerFactory.newInstance().newTransformer().transform(src, res);