@Test
public void test() throws ParserConfigurationException, IOException, SAXException
{
  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
  DocumentBuilder builder;

  builder = factory.newDocumentBuilder();
  org.w3c.dom.Document document = builder.parse(new InputSource(new StringReader(responseXML)));
  NodeList offersList = document.getElementsByTagName("getOffers");
  for (int j = 0; j < offersList.getLength(); j++)
  {
    Element offer = (Element) offersList.item(j);

    NodeList nList = offer.getElementsByTagName("item");
    for (int i = 0; i < nList.getLength(); i++)
    {
      Element element = (Element) nList.item(i);

      String offerUd = element.getElementsByTagName("offerId").item(0).getTextContent() != null ? element.getElementsByTagName("offerId").item(0).getTextContent() : "";
      System.out.println(offerUd);
    }
  }
}