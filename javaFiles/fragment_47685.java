@Override
public void startElement(final String uri, final String localName,
    final String qName, final Attributes attributes) throws SAXException {

    if(localName.equalsIgnoreCase("employee") || localName.equalsIgnoreCase("street")) {
        final String validated = attributes.getValue("validated");
        if(validated != null && !validated.equals("False")) {
            throw new SAXException(localName + " has already been validated");
        } else {
            //your processing logic here
        }
    }
}