TransformerFactory transformerFactory = TransformerFactory.newInstance();
Transformer transformer = transformerFactory.newTransformer();
transformer.setOutputProperty(OutputKeys.INDENT, "yes");
transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
transformer.setOutputProperty(OutputKeys.METHOD, "xml");
DOMImplementation domImpl = document.getImplementation();
DocumentType doctype = domImpl.createDocumentType("doctype",
    "-//Oberon//YOUR PUBLIC DOCTYPE//EN",
    "YOURDTD.dtd");
transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, doctype.getPublicId());
transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());
DOMSource source = new DOMSource(document);
StreamResult result = new StreamResult(new File(database));
transformer.transform(source, result);