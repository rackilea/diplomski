XPath xpath = XPathFactory.newInstance().newXPath();
// load
Document xml1 = (Document) xpath.evaluate("/", new InputSource("xml1.xml"),
    XPathConstants.NODE);
NodeList listPosts = (NodeList) xpath.evaluate("/DigestType/Blog/listPost",
    new InputSource("xml2.xml"), XPathConstants.NODESET);
// merge
Element blog = (Element) xpath.evaluate("/DigestType/Blog", xml1,
    XPathConstants.NODE);
for (int i = 0; i < listPosts.getLength(); i++) {
  Node listPost = listPosts.item(i);
  blog.appendChild(xml1.adoptNode(listPost));
}
// set count
blog.setAttribute("Count", xpath.evaluate("count(listPost)", blog));
// print
DOMImplementationLS impl = (DOMImplementationLS) xml1.getImplementation();
System.out.println(impl.createLSSerializer().writeToString(xml1));