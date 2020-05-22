XPath xpath = xPathfactory.newXPath();
SimpleNamespaceContext nsCtx = new SimpleNamespaceContext();
xpath.setNamespaceContext(nsCtx);
nsCtx.bindNamespaceUri("pom", "http://maven.apache.org/POM/4.0.0");

// ...
Node node = (Node)xpath.evaluate("/pom:project/pom:parent/pom:version/text()", source, XPathConstants.NODE);