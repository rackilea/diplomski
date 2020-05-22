NodeList children = nList.item(i).getChildNodes();
         for (int j = 0; j < children.getLength(); j++) {

             Node cNode = children.item(j);
             if (cNode.getNodeType() == Node.ELEMENT_NODE) {
                 Element eElement = (Element) cNode;
                 System.out.println(eElement.getAttribute("et"));
             }
         }