DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse("yourDocumentName");
    doc.getDocumentElement().normalize();
    NodeList nlList = doc.getElementsByTagName("input");
    for (int indx= 0; indx < nList.getLength(); indx++) {
       Element eElement = (Element) nList.item(indx);
       if(eElement.getAttribute("name").equals("EnterName")){
              System.out.println("EnterName: " + eElement.getNodeValue());
       }
    }

    NodeList nlList1 = doc.getElementsByTagName("select");
    for (int indx= 0; indx < nList1.getLength(); indx++) {
       Element eElement = (Element) nList1.item(indx);
       if(eElement.getAttribute("name").equals("SelectOptions")){
              System.out.println("SelectOptions: " + eElement.getNodeValue());
       }
    }