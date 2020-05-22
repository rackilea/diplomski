XPathExpression xPathExpression = xPath.compile("//parentNode/*");
   NodeList children = (NodeList) xPathExpression.evaluate(config, XPathConstants.NODESET);

   for (int i = 0; i < children.getLength(); i++) {
   // maintain hashset of clients here and check if element is already there
   }