public class XmlSerializer {

private String input;
private Element currentNode, currentChild, currentObject;
private Map<String, Element> nodes;
private Map<Element, Map<String, Element>> children, objects;

/**
 * Initializes the serializer with the given input string.
 * @param  input input string
 */
public XmlSerializer(String input) {
    this.input = input;
    this.nodes = new HashMap<String, Element>();
    this.children = new HashMap<Element, Map<String,Element>>();
    this.objects = new HashMap<Element, Map<String,Element>>();
}

/**
 * Parses the input string and returns the XML document.
 * @return XML document
 */
public Document parseDocument()
throws ParserConfigurationException {
    Pattern pattern = Pattern.compile("\\[(.+?)\\((.+?)\\)\\]");
    Matcher matcher = pattern.matcher(input);
    Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    Element root = dom.createElement("root");
    dom.appendChild(root);

    while (matcher.find()) {
        String key = matcher.group(1);
        String value = matcher.group(2);

        if ("Node".equals(key)) {
            currentNode = parseElement(key, value, dom, root, nodes, children);
        } else if (currentNode != null && key.startsWith("CHILD")) {
            currentChild = parseElement(key, value, dom, currentNode,
                    children.get(currentNode), objects);
        } else if (currentChild != null && key.startsWith("OBJECT")) {
            currentObject = parseElement(key, value, dom, currentChild,
                    objects.get(currentChild), null);
        } else {
            Element property = parseProperty(key, value, dom);
            currentObject.appendChild(property);
        }
    }

    return dom;
}

/**
 * Returns the parsed XML document as string.
 * @return XML document as string
 */
public String toXML()
throws TransformerFactoryConfigurationError, ParserConfigurationException, TransformerException {
    StringWriter writer = new StringWriter();
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
    Source source = new DOMSource(parseDocument());
    Result result = new StreamResult(writer);
    transformer.transform(source, result);
    return writer.getBuffer().toString();
}

/**
 * Parses an element.
 * @param  key      key in {@code [key(value)]} string
 * @param  value    value in {@code [key(value)]} string
 * @param  dom      DOM
 * @param  parent   parent element to add this element to
 * @param  cache    cache for the parsed element
 * @param  subCache sub-cache to initialize (optional)
 * @return the element
 */
private Element parseElement(String key, String value, Document dom, Element parent,
        Map<String, Element> cache, Map<Element, Map<String, Element>> subCache) {
    Element el = cache.get(value);
    if (el == null) {
        el = dom.createElement(value);
        cache.put(key, el);
        parent.appendChild(el);
        if (subCache != null)
            subCache.put(el, new HashMap<String, Element>());
    }
    return el;
}

/**
 * Parses a property element.
 * @param  key   key in {@code [key(value)]} string
 * @param  value value in {@code [key(value)]} string
 * @param  dom   DOM
 * @return the element
 */
private Element parseProperty(String key, String value, Document dom) {
    Element property = dom.createElement(key);
    property.setTextContent(value);
    return property;
}

}