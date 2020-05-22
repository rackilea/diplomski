try (InputStream config = getClass().getResourceAsStream("/files/config-prod.xml")) {

    NodeList values = (NodeList)
        xpath.evaluate("//tags/tag[@id=2]/@example", new InputSource(config),
            XPathConstants.NODESET);

    int count = values.getLength();
    for (int i = 0; i < count; i++) {
        String value = values.item(i).getNodeValue();
        System.out.println("Found value \"" + value + "\"");
    }
}