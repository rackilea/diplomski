StreamSource xslt = new StreamSource(new File("transform.xsl"));
Transformer transformer = TransformerFactory.newInstance().newTransformer(xslt);
transformer.setParameter("newVersion", newValue);
StreamSource input = new StreamSource(new File("C:\\pom.xml"));
StreamResult output = new StreamResult(new File("C:\\updated-pom.xml"));
transformer.transform(input, output);