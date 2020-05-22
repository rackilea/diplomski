public static List<String> MOIDList(File file) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException{
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder(); 
    Document doc = db.parse(file);

       XPath xPath = XPathFactory.newInstance().newXPath();
       XPathExpression exp = xPath.compile("//NE | //UNIT");
       NodeList nl = (NodeList)exp.evaluate(doc, XPathConstants.NODESET);

        List<String> MoidList = new ArrayList<>();
    for (int i = 0; i < nl.getLength(); i++) {
        String moid=((Element)nl.item(i)).getAttribute("MOID");
            MoidList.add(moid);
    }
    return MoidList;

}