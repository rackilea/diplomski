String namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
factory.setNamespaceAware(true);
final Document requestDoc = factory.newDocumentBuilder().parse(new FileInputStream(SOAP_REQUEST));
docElement.getElementsByTagNameNS(namespace, "Username").item(0).setTextContent(configProperties.getProperty("username"));
docElement.getElementsByTagNameNS(namespace, "Password").item(0).setTextContent(configProperties.getProperty("password"));