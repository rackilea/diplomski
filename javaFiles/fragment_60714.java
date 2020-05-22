NodeList nl = doc.getFirstChild().getChildNodes();
        for (int i = 0; i < nl.getLength(); i++){
            Node first = nl.item(i);
            if (first.getNodeType() == Node.ELEMENT_NODE){
                System.out.println("first:" + first);
                NamedNodeMap att = first.getAttributes();
                System.out.println("att:" + att);
            }

        }