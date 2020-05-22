DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    DocumentBuilder builder = factory.newDocumentBuilder();

    Document d1 = builder.parse(...);
    Document d2 = builder.parse(...);

    d1.getDocumentElement().appendChild(d1.importNode(d2.getDocumentElement(), true));