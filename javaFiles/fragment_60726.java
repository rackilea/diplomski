try {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new InputSource(new StringReader(response)));

        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());
        NodeList nodeList = document.getElementsByTagName(root.getNodeName());
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                System.out.println("Country Name : "  + eElement.getElementsByTagName("wb:country").item(0).getTextContent());
            }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }