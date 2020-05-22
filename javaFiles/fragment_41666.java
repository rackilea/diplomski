TransformerFactory tFactory = TransformerFactory.newInstance();
Transformer transformer = tFactory.newTransformer();
transformer.setOutputProperty(OutputKeys.INDENT, "yes");
transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
DOMSource source = new DOMSource(dom);
StreamResult result = new StreamResult(System.out);
transformer.transform(source, result);