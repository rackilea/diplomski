public App() {
  super();
  try {
    test( testDoc1() );
    test( testDoc2() );
  } catch( Exception e ) {
    e.printStackTrace();
  } finally {
    Log.d( "TEST-FINISHED", "test is finished" );
  }
}
private String toXmlString(Document document) throws TransformerException {
  DOMSource domSource = new DOMSource(document);
  StringWriter writer = new StringWriter();
  StreamResult result = new StreamResult(writer);
  TransformerFactory tf = TransformerFactory.newInstance();
  Transformer transformer = tf.newTransformer();
  transformer.transform(domSource, result);
  return writer.toString();
}

private Document testDoc1() throws ParserConfigurationException {
  DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
  documentBuilderFactory.setNamespaceAware(true);
  Document mDocument = documentBuilderFactory.newDocumentBuilder().newDocument();

  String XMLNS_NAMESPACE_URI = "http://www.w3.org/2000/xmlns/";
  //Element mKmlElement = mDocument.createElement("kml");
  Element mKmlElement = mDocument.createElementNS("http://www.opengis.net/kml/2.2", "kml");
  //mKmlElement.setAttributeNS(XMLNS_NAMESPACE_URI, "xmlns", "http://www.opengis.net/kml/2.2");
  mKmlElement.setAttributeNS(XMLNS_NAMESPACE_URI, "xmlns:gx", "http://www.google.com/kml/ext/2.2");
  mDocument.appendChild(mKmlElement);


  //Element mPlacemarkElement = mDocument.createElement("Placemark");
  Element mPlacemarkElement = mDocument.createElementNS("http://www.opengis.net/kml/2.2", "Placemark");
  //mPlacemarkElement.setAttributeNS(XMLNS_NAMESPACE_URI, "xmlns", "http://www.opengis.net/kml/2.2");
  mKmlElement.appendChild(mPlacemarkElement);

  //Element gxTrackElement = mDocument.createElement("gx:Track");
  Element gxTrackElement = mDocument.createElementNS("http://www.google.com/kml/ext/2.2","gx:Track");
  mPlacemarkElement.appendChild(gxTrackElement);

  //Element gxCoordElement = mDocument.createElement("gx:coord");
  Element gxCoordElement = mDocument.createElementNS("http://www.google.com/kml/ext/2.2", "gx:coord");
  gxCoordElement.setTextContent("-122.207881 37.371915 156.000000");
  gxTrackElement.appendChild(gxCoordElement);

  return mDocument;
}

private Document testDoc2() throws ParserConfigurationException, IOException, SAXException {
  String kmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><kml xmlns=\"http://www.opengis.net/kml/2.2\" xmlns:gx=\"http://www.google.com/kml/ext/2.2\"><Placemark><gx:Track><gx:coord>-122.207881 37.371915 156.000000</gx:coord></gx:Track></Placemark></kml>";

  DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
  documentBuilderFactory.setNamespaceAware(true);
  Document mDocument = documentBuilderFactory.newDocumentBuilder().parse(new 
  InputSource(new StringReader(kmlString)));

  return mDocument;
}

private void test(Document mDocument) throws Exception {
  String xml = toXmlString(mDocument);
  System.out.println( xml);

  XPath xPath = XPathFactory.newInstance().newXPath();

  xPath.setNamespaceContext(new NamespaceContext() {
    @Override
    public String getNamespaceURI(String prefix) {
      return "gx".equals(prefix) ? "http://www.google.com/kml/ext/2.2" : "http://www.opengis.net/kml/2.2";
    }

    @Override
    public String getPrefix(String namespaceURI) {
      if ("http://www.google.com/kml/ext/2.2".equals(namespaceURI)) {
        return "gx";
      }
      return null;
    }

    @Override
    public Iterator getPrefixes(String namespaceURI) {
      List<String> ns = new ArrayList<>();
      ns.add("gx");
      return ns.iterator();
    }
  });

  NodeList result1 = (NodeList) xPath.evaluate("/k:kml", mDocument, XPathConstants.NODESET);
  System.out.println(String.valueOf(result1.getLength()));
  System.out.println("Namespace URI: " + result1.item(0).getNamespaceURI());
  System.out.println("Prefix: " + result1.item(0).getPrefix());

  NodeList result2 = (NodeList) xPath.evaluate("/k:kml/k:Placemark", mDocument, XPathConstants.NODESET);
  System.out.println( String.valueOf(result2.getLength()));
  NodeList result3 = (NodeList) xPath.evaluate("/k:kml/k:Placemark/gx:Track", mDocument, XPathConstants.NODESET);
  System.out.println(String.valueOf(result3.getLength()));

}