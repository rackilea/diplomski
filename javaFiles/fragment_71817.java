public void startElement(String ns, String localName, String qName, Attributes attrs) throws SAXException {
    for(int i = 0; i < attrs.getLength(); ++i) {
        String attrName = attrs.getLocalName(i);
        String attrValue = attrs.getValue(i);

        //do stuff with name/value
    }
}