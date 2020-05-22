DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
dbFactory.setNamespaceAware(true); // parse with namespaces
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(xmlResponse.getBytes("utf-8"))));
doc.getDocumentElement().normalize();

XPath xPath =  XPathFactory.newInstance().newXPath();
SimpleNamespaceContext nsCtx = new SimpleNamespaceContext();
xPath.setNamespaceContext(nsCtx);
nsCtx.bindNamespaceUri("prod", "http://mws.amazonservices.com/schema/Products/2011-10-01");
nsCtx.bindNamespaceUri("ns2", "http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd");
String expression = "/prod:GetMatchingProductForIdResponse/prod:GetMatchingProductForIdResult/prod:Products/prod:Product‌​/prod:AttributeSets/ns2:ItemAttributes/ns2:Binding";
// ...