File fXmlFile = new File("SearchPromotions.xml");
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(fXmlFile);
doc.getDocumentElement().normalize();

Element docEle = doc.getDocumentElement();
NodeList nl = docEle.getChildNodes();
if (nl != null && nl.getLength() > 0) {
      for (int i = 0; i < nl.getLength(); i++) {
           if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) nl.item(i);
                System.out.println(el);
            }
      }
}