@Override
public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {

    int length = attributes.getLength();

    for(int i=0; i<length; i++) {

            // Qualified name by index
            String name = attributes.getQName(i);

            // Attribute value by index
            String value = attributes.getValue(i);

            // Namespace URI by index
            String nsUri = attributes.getURI(i);

            // Local name by index
            String lName = attributes.getLocalName(i);
        }
    }