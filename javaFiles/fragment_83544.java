Transformer tf = TransformerFactory.newInstance().newTransformer();
tf.setOutputProperty(OutputKeys.INDENT, "yes");
tf.setOutputProperty(OutputKeys.METHOD, "xml");
tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

DOMSource domSource = new DOMSource(doc);
StreamResult sr = new StreamResult(System.out);
tf.transform(domSource, sr);