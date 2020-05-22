if (this == null) return null;  

javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();   

javax.xml.transform.Transformer transformer = tf.newTransformer();  

transformer.setOutputProperty(javax.xml.transform.OutputKeys.METHOD, "xml");  
transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");  
transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");  


javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(this);  
if (source == null) return "Corrupted XML document: " + this.toString();  

java.io.StringWriter os = new java.io.StringWriter();  
javax.xml.transform.stream.StreamResult result = new   javax.xml.transform.stream.StreamResult(os);  
transformer.transform(source,result);  

return os.toString ();