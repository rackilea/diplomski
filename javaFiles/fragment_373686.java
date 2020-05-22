// Get the Envelope Source 
Source src = message.getSOAPPart().getContent() ;

// Transform the Source into a StreamResult to get the XML
Transformer transformer = TransformerFactory.newInstance().newTransformer();
transformer.setOutputProperty(OutputKeys.INDENT, "no");
StreamResult result = new StreamResult(new StringWriter());
transformer.transform(src, result);
String xmlString = result.getWriter().toString();