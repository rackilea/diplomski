private static String parseXmlData() throws ParserConfigurationException, SAXException, IOException {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><req:messages xmlns:req=\"http://hp.com/ecc/request/\"><req:message category=\"GENERIC\" type=\"error\" number=\"6\">Null pointer exception occured.</req:message><req:message category=\"GENERIC\" type=\"error\" number=\"6\">Arithmetic exception occured.</req:message><req:message category=\"GENERIC\" type=\"error\" number=\"6\">Class not found exception occured.</req:message></req:messages>";
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(str));
        Document doc = db.parse(is);
        NodeList nodes = doc.getElementsByTagName("req:message");
        StringBuilder sb = new StringBuilder();        
        for (int i = 0; i < nodes.getLength(); i++) {
          Element element = (Element) nodes.item(i);
          sb.append(getCharacterDataFromElement(element) + System.lineSeparator());
        }
        return sb.toString();
    }