public class TestXML03 {

    public static void main(String[] args) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDoc = builder.parse(new File("Test.xml"));

            Node root = xmlDoc.getDocumentElement();

            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xPath = xFactory.newXPath();

            XPathExpression xExpress = xPath.compile("/file/location");
            NodeList nodes = (NodeList) xExpress.evaluate(root, XPathConstants.NODESET);

            System.out.println("Found " + nodes.getLength() + " location nodes");
            System.out.println("");

            for (int index = 0; index < nodes.getLength(); index++) {
                Node node = nodes.item(index);
                xExpress = xPath.compile("filmid");
                Node filmIDNode = (Node) xExpress.evaluate(node, XPathConstants.NODE);
                System.out.println(filmIDNode.getNodeName() + " = " + filmIDNode.getTextContent());

                xExpress = xPath.compile("date");
                Node dateNode = (Node) xExpress.evaluate(node, XPathConstants.NODE);
                System.out.println(dateNode.getNodeName() + " = " + dateNode.getTextContent());

                xExpress = xPath.compile("amount");
                Node amountNode = (Node) xExpress.evaluate(node, XPathConstants.NODE);
                System.out.println(amountNode.getNodeName() + " = " + amountNode.getTextContent());

                System.out.println("");
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}