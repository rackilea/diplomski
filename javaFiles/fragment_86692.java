public static void main(String... args)
        throws Exception
{
    // BEGIN: DOM Boilerplate
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(new File("input.xml"));
    XPathFactory xPathfactory = XPathFactory.newInstance();
    XPath xpath = xPathfactory.newXPath();
    // END: DOM Boilerplate

    // Find and iterate over CHARGE_SUMMARY nodes
    XPathExpression chargeQuery = xpath.compile("/REPORT/REPORT_SUMMARY/CHARGE_SUMMARY");
    NodeList chargeSummaries = (NodeList) chargeQuery.evaluate(doc, XPathConstants.NODESET);
    for (int i = 0; i < chargeSummaries.getLength(); i++) {
        Element chargeSummary = (Element) chargeSummaries.item(i);

        System.out.printf("CHARGE_SUMMARY amount=\"%s\" date=\"%s\" name=\"%s\"%n",
                chargeSummary.getAttribute("amount"),
                chargeSummary.getAttribute("date"),
                chargeSummary.getAttribute("name"));
    }

    // Find and iterate over VALUE nodes
    XPathExpression valueQuery = xpath.compile("/REPORT/REPORT_DETAIL/RESOURCE/CHARGE/VALUE");
    NodeList values = (NodeList) valueQuery.evaluate(doc, XPathConstants.NODESET);
    String lastResourceName = null;
    for (int i = 0; i < values.getLength(); i++) {
        Element value = (Element) values.item(i);

        String resourceName = ((Element) value.getParentNode().getParentNode()).getAttribute("name");

        if (!resourceName.equals(lastResourceName)) {
            lastResourceName = resourceName;
            System.out.println();
        }

        System.out.printf("RESOURCE name=\"%s\" CHARGE name=\"%s\" VALUE amount=\"%s\" datetime=\"%s\"%n",
                resourceName,
                ((Element) value.getParentNode()).getAttribute("name"),
                value.getAttribute("amount"),
                value.getAttribute("datetime"));
    }
}