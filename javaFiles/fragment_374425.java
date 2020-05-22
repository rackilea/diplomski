// output DOM as String
Transformer transformer = TransformerFactory.newInstance().newTransformer();
StringWriter sw = new StringWriter();
transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
transformer.transform(new DOMSource(doc), new StreamResult(sw));
String italicsContent = sw.toString();