String namespaceURI = "http://www.w3.org/2000/xmlns/";
DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

Document doc = docBuilder.newDocument();
Element rootElement = doc.createElementNS(namespaceURI, "OmgeoMessageContainer");

doc.appendChild(rootElement);
Element messageParties = doc.createElementNS(namespaceURI, "MessageParties");
rootElement.appendChild(messageParties);