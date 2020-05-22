public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
    if(atts == null) return;
        if(localName.equals("transaction") && "2".equals(atts.getValue("ts"))) {
            // TODO: Whatever should happen when condition is reached
            throw new SAXException("Condition reached. Just skip rest of parsing");
        }
    }