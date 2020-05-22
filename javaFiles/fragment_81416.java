File fXmlFile = new File("your xml file path");
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(fXmlFile);
NodeList nodeList = doc.getElementsByTagName("service_addr");
   for(int i = 0; i < nodeList.getLength(); i++) {
      System.out.println(nodeList.item(i).getTextContent().trim());
   }