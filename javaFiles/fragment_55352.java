URL url = new URL("https://suggestqueries.google.com/complete/search?output=toolbar&hl=en&q=¥");
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
Document doc = db.parse(new InputSource(new InputStreamReader(url.openStream(), "ISO-8859-1")));
doc.getDocumentElement().normalize();

NodeList nodeList = doc.getElementsByTagName("suggestion");

for (int i = 0; i < 10; i++) {
    Node node = nodeList.item(i);
    if(node==null){
        break;
    }
    String suggestion = node.getAttributes().getNamedItem("data").getTextContent();
    System.out.println(suggestion);
}