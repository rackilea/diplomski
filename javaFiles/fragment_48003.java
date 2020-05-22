public final class AttrsUtils {

    private static final String TAG_ATTR = "attr";
    private static final String TAG_ENUM = "enum";
    private static final String ATTRIBUTE_NAME = "name";
    private static final String ATTRIBUTE_FORMAT = "format";
    private static final String ATTRIBUTE_VALUE = "value";

    @CheckResult
    @NonNull
    public static Map<String, Integer> getEnumAttributeValues(String attrName)
            throws ParserConfigurationException, IOException, SAXException {
        final File attrsFile = new File("../app/src/main/res/values/attrs.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(attrsFile);
        doc.getDocumentElement().normalize();

        Map<String, Integer> fontAttributes = new ArrayMap<>();

        NodeList nList = doc.getElementsByTagName(TAG_ATTR);
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node attrNode = nList.item(temp);
            if (attrNode.getNodeType() == Node.ELEMENT_NODE) {
                Element attrElement = (Element) attrNode;
                final String name = attrElement.getAttribute(ATTRIBUTE_NAME);
                if (!attrElement.hasAttribute(ATTRIBUTE_FORMAT) || !name.equals(attrName)) {
                    continue;
                }

                final NodeList enumNodeList = attrElement.getElementsByTagName(TAG_ENUM);
                for (int i = 0, size = enumNodeList.getLength(); i < size; ++i) {
                    final Node enumNode = enumNodeList.item(i);
                    if (enumNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element enumElement = (Element) enumNode;
                        fontAttributes.put(
                                enumElement.getAttribute(ATTRIBUTE_NAME),
                                Integer.parseInt(enumElement.getAttribute(ATTRIBUTE_VALUE)));
                    }
                }
                break; // we already found the right attr, we can break the loop
            }
        }
        return fontAttributes;
    }

    // Suppress default constructor for noninstantiability
    private AttrsUtils() {
        throw new AssertionError();
    }
}