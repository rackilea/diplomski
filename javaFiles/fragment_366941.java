try {

        File fXmlFile = new File(
                "D:\\StackOverFlow\\SAXParserRelated\\src\\stocks.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        doc.getDocumentElement().normalize();

        System.out.println("Root element :"
                + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("element");

        System.out.println("----------------------------");

        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);

            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
                if ((eElement.hasChildNodes())
                        && (eElement.getElementsByTagName("name").item(0) != null)
                        && (eElement.getElementsByTagName("text").item(0) != null)) {

                    System.out.println(" Name : "
                            + eElement.getElementsByTagName("name").item(0)
                                    .getTextContent());
                    System.out.println("Text : "
                            + eElement.getElementsByTagName("text").item(0)
                                    .getTextContent());
                }

            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }