public class ExampleHandler extends DefaultHandler {

    private String item;
    private boolean inItem = false;

    private StringBuilder content;

    public ExampleHandler() {
        items = new Items();
        content = new StringBuilder();
    }

    public void startElement(String uri, String localName, String qName, 
            Attributes atts) throws SAXException {
        content = new StringBuilder();
        if(localName.equalsIgnoreCase("propname")) {
            inItem = true;
        } else attributes.getValue("key");

    }

    public void endElement(String uri, String localName, String qName) 
            throws SAXException {
        if(localName.equalsIgnoreCase("propname")) {
            if(inItem) {
                item = (content.toString());
              }
    }

    public void characters(char[] ch, int start, int length) 
            throws SAXException {
        content.append(ch, start, length);
    }

    public void endDocument() throws SAXException {
        // you can do something here for example send
        // the Channel object somewhere or whatever.
    }

}