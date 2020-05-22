public class Main {
    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(MyData.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(new MyData("Test < ' \" & >", "Test < ' \" & >"), System.out);

        System.out.println();

        marshaller.marshal(new MyData("Test < ' \" & >", "Test < ' \" & >"), new MyContentHandler());
    }
}
@XmlRootElement
class MyData {
    @XmlAttribute private String name;
    @XmlElement   private String desc;
    public MyData() {}
    public MyData(String name, String desc) { this.name = name; this.desc = desc; }
}
class MyContentHandler implements ContentHandler {
    @Override
    public void setDocumentLocator(Locator locator) {
        // Nothing to do
    }
    @Override
    public void startDocument() throws SAXException {
        System.out.print("<?xml version=\"1.0\" encoding=\"" + Charset.defaultCharset() + "\" standalone=\"yes\"?>");
    }
    @Override
    public void endDocument() throws SAXException {
        // Nothing to do
    }
    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        throw new UnsupportedOperationException();
    }
    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        throw new UnsupportedOperationException();
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        System.out.print('<' + localName);
        for (int i = 0; i < atts.getLength(); i++)
            System.out.print(' ' + atts.getLocalName(i) + "=\"" + escape(atts.getValue(i)) + '"');
        System.out.print('>');
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.print("</" + localName + ">");
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.print(escape(new String(ch, start, length)));
    }
    private static String escape(String text) {
        return text.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;")
                   .replace("'", "&apos;")
                   .replace("\"", "&quot;");
    }
    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        throw new UnsupportedOperationException();
    }
    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        throw new UnsupportedOperationException();
    }
    @Override
    public void skippedEntity(String name) throws SAXException {
        throw new UnsupportedOperationException();
    }
}