//XMLSignature result of validation process
XMLSignature signature = ...

//Gets the node
XMLObject xmlObject = (XMLObject)signature.getObjects().get(0);
Node yourXmlNode = ((DOMStructure)xmlObject.getContent().get(0)).getNode();

//Save to file
OutputStream os = new FileOutputStream(outputFileName);
TransformerFactory tf = TransformerFactory.newInstance();
Transformer trans = tf.newTransformer();
trans.transform(new DOMSource(yourXmlNode), new StreamResult(os));