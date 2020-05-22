public static void main(String[] args) {
  try {
    InputSource root = new InputSource(XMLParse.class.getResourceAsStream("/data.xml"));
      XPath xPath = XPathFactory.newInstance().newXPath();
      NodeList nList = (NodeList)xPath.evaluate("/plist/dict/dict/dict/key[text()='Name']/following::string[1]", root, XPathConstants.NODESET);
      for (int i = 0; i < nList.getLength(); ++i) {
          Element e = (Element) nList.item(i);
          String value = e.getFirstChild().getNodeValue();

          System.out.println("string:" + value+"");

      }
 }  catch (XPathExpressionException e) {

    e.printStackTrace();
 } catch (DOMException e) {

    e.printStackTrace();
 }
}