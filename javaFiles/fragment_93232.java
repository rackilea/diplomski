public final class XpathEvaluator {
    private DocumentBuilder builder;
    private Document document;

    public XpathEvaluator() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            Logger.error("Can not create document builder for xpath ", e.getCause());
        }
    }

    public void loadFile(String filename) {
        Logger.operation("Load file for Xpath evaluation: " + filename);
        File file = new File(filename);
        try {
            document = builder.parse(file);
        } catch (SAXException | IOException e) {
            Logger.error("exception at loading xml file", e.getCause());
        }
    }

    public List<NodeSearchResult> getXpathSearchResults(String xpathExpression) {
        Logger.operation("Evaluate xpath expression: [" + xpathExpression + "]");
        List<NodeSearchResult> results = new ArrayList<>();

        XPathExpression expression;
        NodeList list = null;
        try {
            expression = getXPath().compile(xpathExpression);
            list = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            Logger.error("XPathExpressionException during xpath evaluation", e.getCause());
        }

        for (int index = 0; index < list.getLength(); index++) {
            Node node = list.item(index);
            String nodeXPath = getFullXPath(node);
            String content = node.getTextContent();

            Logger.debug("Get NODE value: [" + content + "]");
            results.add(new NodeSearchResult(nodeXPath, content));
        }

        if (results.isEmpty()) { // log error if node result is empty
            Logger.warn("XPATH result is EMPTY, for next xpath [" + xpathExpression + "]");
            return Collections.emptyList();
        }

        Logger.operation("Xpath evaluation results: " + results);
        return results;
    }

    private String getFullXPath(Node n) {
        if (null == n)
            return null;

        Node parent;
        Stack<Node> hierarchy = new Stack<>();
        StringBuilder builder = new StringBuilder();

        hierarchy.push(n);

        switch (n.getNodeType()) {
            case Node.ATTRIBUTE_NODE:
                parent = ((Attr) n).getOwnerElement();
                break;
            case Node.ELEMENT_NODE:
                parent = n.getParentNode();
                break;
            case Node.DOCUMENT_NODE:
                parent = n.getParentNode();
                break;
            default:
                throw new IllegalStateException("Unexpected Node type" + n.getNodeType());
        }

        while (null != parent
                && parent.getNodeType() != Node.DOCUMENT_NODE
                && !parent.getNodeName().equals("section")) {
            hierarchy.push(parent);
            parent = parent.getParentNode();
        }

        Object obj;
        while (!hierarchy.isEmpty() && null != (obj = hierarchy.pop())) {
            Node node = (Node) obj;

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                builder.append("/").append(node.getNodeName());

                int prev_siblings = 1;
                Node prev_sibling = node.getPreviousSibling();

                while (null != prev_sibling) {
                    if (prev_sibling.getNodeType() == node.getNodeType()) {
                        if (prev_sibling.getNodeName().equalsIgnoreCase(node.getNodeName())) {
                            prev_siblings++;
                        }
                    }
                    prev_sibling = prev_sibling.getPreviousSibling();
                }
                builder.append("[").append(prev_siblings).append("]");
            } else if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
                builder.append("/@");
                builder.append(node.getNodeName());
            }
        }

        return builder.toString();
    }

    private XPath getXPath() {
        XPathFactory pathFactory = XPathFactory.newInstance();
        return pathFactory.newXPath();
    }