Transformer transformer = TransformerFactory.newInstance().newTransformer();
transformer.setOutputProperty(OutputKeys.INDENT, "yes");
transformer.setOutputProperty(OutputKeys.ENCODING, ENCODING);
transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", INDENT);
StreamResult result = new StreamResult(writer);
DOMSource source = new DOMSource(document);
transformer.transform(source, result);