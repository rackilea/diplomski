NodeList autocueNodes = myDoc.getElementsByTagName("autocue");//here myDoc is the reference for getting document for the parser
    for (int i = 0; i < autocueNodes.getLength(); i++) {
        NodeList autocueChildNodes = autocueNodes.item(i).getChildNodes();
        if (autocueChildNodes.item(i).getLocalName() != null
                && autocueChildNodes.item(i).getLocalName().equals("sentence")) {
            NodeList sentenceList = autocueChildNodes.item(i).getChildNodes();
            for (int j = 0; j < sentenceList.getLength(); j++) {
                if (sentenceList.item(j).getLocalName() != null
                        && sentenceList.item(j).getLocalName()
                                .equals("text")) {
                    String text = sentenceList.item(j).getNodeValue();
                }
            }
        }

    }