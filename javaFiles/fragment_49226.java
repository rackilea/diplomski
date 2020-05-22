DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        org.w3c.dom.Document myDoc = db.parse(new File("D:/bb.xml"));
        org.w3c.dom.NodeList bbbNodes = myDoc.getElementsByTagName("bbb");
        for (int i=0; i < bbbNodes.getLength(); i++) {
            if (bbbNodes.item(i).hasAttributes())
                System.out.println(bbbNodes.item(i).getAttributes().getNamedItem("name"));
            org.w3c.dom.NodeList cccNodes = bbbNodes.item(i).getChildNodes();
            for (int j=0; j < cccNodes.getLength(); j++) {
                if (cccNodes.item(j).hasAttributes())
                    System.out.println(cccNodes.item(j).getAttributes().getNamedItem("B"));
            }
        }