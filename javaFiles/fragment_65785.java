URL endpoint = new URL("http://www.webservicex.net/whois.asmx");
SOAPMessage message = connection.call(sm, endpoint);
XPath xpath = XPathFactory.newInstance().newXPath();
xpath.setNamespaceContext(new SoapNamespaceContext());
Node resultNode = (Node) xpath.evaluate("//m:GetWhoISResult", message.getSOAPBody(), XPathConstants.NODE);
... do something with resultNode...