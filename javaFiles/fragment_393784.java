public class CustomHandler extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        System.out.println();
        System.out.print("<" + qName + "");
        if (attributes.getLength() == 0) {
            System.out.print(">");
        } else {
            System.out.print(" ");
            for (int index = 0; index < attributes.getLength(); index++) {
                System.out.print(attributes.getLocalName(index) + " => "
                        + attributes.getValue(index));
            }
            System.out.print(">");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.print("\n</" + qName + ">");
    }
}