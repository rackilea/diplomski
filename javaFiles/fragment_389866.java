public static void main(String[] args) {
        try {
            File inputFile = new File("Snippet.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("year");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (Integer.parseInt(eElement.getAttribute("id")) == 1) { // Found year 1
                        NodeList semeterList = nNode.getChildNodes();
                        for (int j = 0; j < semeterList.getLength(); j++) {
                            nNode = semeterList.item(j);
                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element semesterNode = (Element) nNode;
                                if (Integer.parseInt(semesterNode.getAttribute("id")) == 1) { //Found semester 1
                                    NodeList moduleList = semesterNode.getChildNodes();
                                    for (int k = 0; k < moduleList.getLength(); k++) {
                                        nNode = moduleList.item(k);
                                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                            Element modeluNode = (Element) nNode;
                                            System.out.println(modeluNode.getElementsByTagName("code").item(0).getTextContent());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Fatal Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }