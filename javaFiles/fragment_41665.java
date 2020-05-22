DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();

Document dom = db.newDocument();

Element element = dom.createElement("string");
element.setAttribute("name", "some_name");

String inputXMLString = 
    "<dhruba><test>this</test>that<test2>node value</test2> some text</dhruba>";
Node n = db.parse(new InputSource(new StringReader(inputXMLString))).getDocumentElement();
n = dom.importNode(n, true);

NodeList nodeList = n.getChildNodes();
for (int i = 0; i < nodeList.getLength(); ++i)
{
    Node node = nodeList.item(i);
    element.appendChild(node.cloneNode(true));
}
dom.appendChild(element);