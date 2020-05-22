SimpleNamespaceContext ctx = new SimpleNamespaceContext();
ctx.bindNamespaceUri("g", namespace); // the same URI as before
ctx.bindNamespaceUri("c", ...); // the namespace bound to gl-cor:
xPath.setNamespaceContext(ctx);

NodeList nodes = (NodeList) xPath.evaluate("/c:entityInformation/g:entityPhoneNumber/g:phoneNumber", xmlDoc, XPathConstants.NODESET);