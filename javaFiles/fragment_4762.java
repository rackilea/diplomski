@Test
public void test() throws ParserConfigurationException, IOException, SAXException
{
  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
  DocumentBuilder builder;

  builder = factory.newDocumentBuilder();
  org.w3c.dom.Document document = builder.parse(new InputSource(new StringReader(responseXML)));
  NodeList nList = document.getElementsByTagName("item");
  for (int i = 0; i < nList.getLength(); i++)
  {
    Element element = (Element) nList.item(i);
    println(element.toString());
    String offerUd = element.getElementsByTagName("offerId").item(0).getTextContent() != null ? element.getElementsByTagName("offerId").item(0).getTextContent() : "";
    println(offerUd);
  }
}

private void println(String t)
{
  System.out.println(t);
}