NodeList nList = doc.getElementsByTagName("data");

        for(int i = 0; i < nList.getLength(); i++){
            Node nNode = nList.item(i);
            System.out.println("\nCurrent Element: " + nNode.getNodeName());
            if(nNode.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) nNode;

                Element point = (Element)(eElement.getElementsByTagName("point").item(0));
                System.out.println("Location: " + point.getAttribute("latitude") + ", " + point.getAttribute("longitude"));
                System.out.println("Start Time: "+eElement.getElementsByTagName("start-valid-time").item(0).getTextContent());
                System.out.println("End Time: "+eElement.getElementsByTagName("end-valid-time").item(0).getTextContent());

                System.out.println("");
            }
        }