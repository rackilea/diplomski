SOAPPart soapPart = message.getSOAPPart();
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = dbFactory.newDocumentBuilder();
Document document = builder.parse("file:///template.xml");
DOMSource domSource = new DOMSource(document);
soapPart.setContent(domSource);