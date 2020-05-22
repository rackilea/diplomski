NamespaceContext context = new NamespaceContextMap(
    "soapenv", "http://schemas.xmlsoap.org/soap/envelope/", 
    "wsa", "http://www.w3.org/2005/08/addressing",
    "axis2", "http://ws.apache.org/namespaces/axis2");
XPathFactory factory = XPathFactory.newInstance();
XPath xpath = factory.newXPath();
xpath.setNamespaceContext(context);
XPathExpression expression = xpath.compile("/soapenv:Envelope/soapenv:Header/wsa:ReplyTo/wsa:ReferenceParameters/axis2:Serv‌​iceGroupId/text()");
System.out.println(expression.evaluate(myXml));