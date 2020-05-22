StringBuilder sb = null;

public void startElement(String uri, String localName,String qName, 
    Attributes attributes) throws SAXException {
    if (qName.equalsIgnoreCase("PEAKS")) {
        sb = new StringBuilder();
    }
}

public void endElement(String uri, String localName, String qName) throws SAXException {
    if (sb == null) return;
    try {
        byte[] array = decompress(DatatypeConverter.parseBase64Binary(sb.toString()));
        System.out.println(array[1]);
    } catch (IOException | DataFormatException e) {e.printStackTrace();}
    sb = null;
}

public void characters(char ch[], int start, int length) throws SAXException {
    if (sb == null) return;
    String currentValue = new String(ch, start, length);
    sb.appens(currentValue);
}