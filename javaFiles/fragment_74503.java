Document d = ....

    XPathFactory xPathfactory = XPathFactory.newInstance();
    XPath xpath = xPathfactory.newXPath();
    XPathExpression expr = xpath.compile("/one/two/three/text()"); // your example expression
    NodeList nl = (NodeList) expr.evaluate(d, XPathConstants.NODESET);
    for (int i = 0; i < nl.getLength(); i++) {
        String n = nl.item(i).getTextContent();
        System.out.println(n); //now do something with the text, like add them to a list or process them directly
    }