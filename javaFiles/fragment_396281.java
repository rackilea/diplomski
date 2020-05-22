// Instantiate the document to be signed.
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
dbf.setNamespaceAware(true);
Document doc = dbf.newDocumentBuilder().parse(new FileInputStream(xml));

// Find Signature element.
NodeList nl = doc.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");

//... XML Signature validation

//remove signature node from DOM
nl.item(0).getParentNode().removeChild(nl.item(0));

//write to file.
OutputStream os = new FileOutputStream(outputFileName);
TransformerFactory tf = TransformerFactory.newInstance();
Transformer trans = tf.newTransformer();
trans.transform(new DOMSource(doc), new StreamResult(os));