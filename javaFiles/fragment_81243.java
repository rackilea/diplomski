pathToWSDL = Is the path to the WSDL
    pathToWSDLRootPath root path of the WSDL, I need to add those to the imports because the schemaLocation where no relative paths in my case

    ...

    DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document wsdlDoc = db.newDocument();

    URL oracle = new URL(pathToWSDL);
    BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
    Source source = new StreamSource(in);

    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    transformer.transform(source, new DOMResult(wsdlDoc));

    NodeList schemaNodes = wsdlDoc.getElementsByTagNameNS(XMLConstants.W3C_XML_SCHEMA_NS_URI, "schema");

    int nrSchemas = schemaNodes.getLength();

    Source[] schemas = new Source[nrSchemas];

    for (int i = 0; i < nrSchemas; i++) {
        DOMSource domSource = new DOMSource(schemaNodes.item(i));

        //Update Schema location by adding path
        NodeList noteList = domSource.getNode().getChildNodes();
        for (int j = 0; j < noteList.getLength(); j++) {
            if("xsd:import".equals(noteList.item(j).getNodeName())){
                NamedNodeMap nodeMap = noteList.item(j).getAttributes();
                for (int attIndex = 0; attIndex < nodeMap.getLength(); attIndex++) {
                    if("schemaLocation".equals(nodeMap.item(attIndex).getNodeName())){
                        nodeMap.item(attIndex).setNodeValue(pathToWSDLRootPath + nodeMap.item(attIndex).getNodeValue());
                    }
                }
            }
        }
        //Show dump
        //StreamResult result = new StreamResult(System.out);
        //transformer.transform(domSource, result); 
        schemas[i] = domSource; 
    }

    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Schema schema = schemaFactory.newSchema(schemas);
    return schema;