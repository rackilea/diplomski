DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse("src/forum6907225/input.xml");
    testClass = (TestClass) unmarshaller.unmarshal(doc);
    marshaller.marshal(testClass, System.out);