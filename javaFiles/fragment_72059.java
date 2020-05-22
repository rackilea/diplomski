public class TestXPath {

    public static void main(String[] args) {
        String xml = "The xml above";

        try {
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            DocumentBuilder b = f.newDocumentBuilder();
            Document d = b.parse(new File("Values.xml"));
            d.getDocumentElement().normalize();

            String expression = "//F[ancestor::D/E[text()='DataE']]|//K[ancestor::D/E[text()='DataE']]|//L[ancestor::D/E[text()='DataE']]";
            XPath xPath = XPathFactory.newInstance().newXPath();
            Object result = xPath.compile(expression).evaluate(d, XPathConstants.NODESET);

            NodeList nodes = (NodeList) result;
            for (int i = 0; i < nodes.getLength(); i++) {

                Node node = nodes.item(i);
                System.out.println("Found " + node.getTextContent());
            }
        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException | DOMException exp) {
            exp.printStackTrace();
        }
    }

}