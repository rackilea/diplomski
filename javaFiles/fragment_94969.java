DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    InputSource is = new InputSource(new StringReader(xml));
    Document doc = builder.parse(is);
    doc.getDocumentElement().normalize();
    NodeList items = doc.getDocumentElement().getElementsByTagName("data").item(0).getChildNodes();

    for(int i=0; i<items.getLength(); i++){
        System.out.println(items.item(i).getNodeName());
    }