try {
            File fXmlFile = new File("/home/angelo/Scrivania/toc.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("navPoint");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("content : " +   eElement.getElementsByTagName("content"));
                    NodeList nl = eElement.getElementsByTagName("content");
                    for(int i = 0; i < nl.getLength(); i++)
                    {
                        Node aNode = nl.item(i);
                        NamedNodeMap nnm = aNode.getAttributes();
                        System.out.println(nnm.getNamedItem("src").getTextContent());
                    }

                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }