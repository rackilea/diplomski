DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
    docBuilderFactory.setNamespaceAware(true);

    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

    Document doc = docBuilder.parse("sampleInput1.xml");

    XPathFactory fact = XPathFactory.newInstance();
    XPath xpath = fact.newXPath();

    NodeList allElements = (NodeList)xpath.evaluate("//*", doc, XPathConstants.NODESET);

    ArrayList<String> elementNames = new ArrayList<>();
    ArrayList<String> elementValues = new ArrayList<>();

    for (int i = 0; i < allElements.getLength(); i++)
    {
        Node currentElement = allElements.item(i);
        elementNames.add(i, currentElement.getLocalName());
        elementValues.add(i, xpath.evaluate("*", currentElement, XPathConstants.NODE) != null ? null : currentElement.getTextContent());
    }

    for (int i = 0; i < elementNames.size(); i++)
    {
        System.out.println("Name: " + elementNames.get(i) + "; value: " + (elementValues.get(i)));
    }