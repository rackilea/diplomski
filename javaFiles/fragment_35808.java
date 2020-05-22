DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    Document document = builder.parse(ResourceUtils.getFile("/itunes.xml").getAbsolutePath());

    Element root = document.getDocumentElement();
    System.out.println(root.getNodeName());
    System.out.println("============================");

    XPath xPath = XPathFactory.newInstance().newXPath();
    NodeList nList = (NodeList)xPath.evaluate("/plist/dict/dict/dict/string", root, XPathConstants.NODESET);
    for (int i = 0; i < nList.getLength(); ++i) {
        Element e = (Element) nList.item(i);
        String value = e.getFirstChild().getNodeValue();
        logger.info("string:" + value);
    }