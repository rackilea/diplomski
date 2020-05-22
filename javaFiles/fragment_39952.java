@Test
public void xmlFileParse () throws ParserConfigurationException, IOException, SAXException {
    List<String> fXmlFile = new ArrayList<String>();
    fXmlFile.add("src/test/resources/fixtures/event.xml");
    fXmlFile.add("src/test/resources/fixtures/country.xml");


    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

    for(String uri: fXmlFile) {
        Document doc = dBuilder.parse(uri);
        NodeList nodes = doc.getElementsByTagName("subscription-update").item(0).getChildNodes();

        for(int i = 0; i < nodes.getLength(); i++){
            Node node = nodes.item(i);
            if(node.getNodeType() == ELEMENT_NODE){
                System.out.println("TABLE: [" + node.getNodeName() + "] ID: [" + node.getAttributes().getNamedItem("id").getNodeValue() + "]");    
                }    
            }
        }
    }