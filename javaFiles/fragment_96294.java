DefaultHandler handler = new DefaultHandler() {
     private StringBuilder stringBuilder;

     @Override
     public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
         stringBuilder = new StringBuilder();
     }

     public void characters(char[] buffer, int start, int length) {
         stringBuilder.append(new String(buffer, start, length));
     }

     public void endElement(String uri, String localName, String qName) throws SAXException {
         System.out.println(stringBuilder.toString());
     }
 };