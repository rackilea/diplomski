private void test(Document mDocument) throws Exception {
  String xml = toXmlString(mDocument);
  System.out.println( xml);
  DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
  documentBuilderFactory.setNamespaceAware(true);
  mDocument = documentBuilderFactory.newDocumentBuilder().parse(new InputSource(new StringReader(xml)));