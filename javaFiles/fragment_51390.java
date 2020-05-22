DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();

            Document doc = factory.newDocumentBuilder().parse(fileLoaded);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :"
                    + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("planes_for_sale");

              System.out.println("----------------------------");

                 for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        System.out.println("Plane name : " 
                           + eElement.getAttribute("name"));
                    }
                 }