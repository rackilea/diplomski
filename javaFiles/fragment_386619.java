public void loadSettings(String variableName) {

    try {
        File inputFile = new File("data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("Setting");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nList.item(temp);
                NodeList VariableName = eElement.getElementsByTagName("VariableName");
                NodeList VariableValue = eElement.getElementsByTagName("VariableValue");
                if (VariableName.item(0).getTextContent().equalsIgnoreCase(variableName)) {

                    String txtBookmarkUrlValue = VariableValue.item(0).getLastChild().getTextContent();
                    System.out.println(txtBookmarkUrlValue);
                    txtBookmarkUrl.setText(txtBookmarkUrlValue);
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}