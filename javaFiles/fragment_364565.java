DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document doc = builder.parse(<uri_as_string>);
XPathFactory xPathfactory = XPathFactory.newInstance();
XPath xpath = xPathfactory.newXPath();
XPathExpression expr = xpath.compile("/patients/patient/stoixeia_astheni/amka/text()");
NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);