public class MySaxHandler extends DefaultHandler {
    public static void main(String[] args) throws Throwable {
        String sXMLData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
                + "<Esp:Interface Version=\"1.0\" xmlns:Esp=\"http://***Confidential****/\">\r\n"
                + "<Esp:Transaction ActionCode=\"APPROVE\" CardNumber=\"474849********28\" ExpiryDate=\"0824\" \r\n"
                + "    ResponseCode=\"00\" TerminalId=\"03563001\" Track2=\"474849********28=08241261234\" \r\n"
                + "    TransactionAmount=\"300\" TransactionId=\"00051\" Type=\"PURCHASE\" LocalDate=\"0823\" \r\n"
                + "    LocalTime=\"152006\" PosOperatorId=\"1234\" AuthorizationNumber=\"123456\" MessageType=\"REFERAL\">\r\n"
                + "</Esp:Transaction>\r\n" + "</Esp:Interface>";
        InputSource source = new InputSource(new StringReader(sXMLData));
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new MySaxHandler());
        reader.parse(source);
    }

    @Override
    public void startElement(String uri, String localName, String qName,
              Attributes atts) throws SAXException {
        if (qName.equals("Esp:Transaction")) {
            for (int i = 0; i < atts.getLength(); i++) {
                System.out.println(atts.getQName(i) + "=\"" + atts.getValue(i) + "\"");
            }
        }
    }
}