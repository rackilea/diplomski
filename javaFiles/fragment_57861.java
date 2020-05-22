Node nNode = nList.item(Integer.parseInt(temp));

    System.out.println("\nCurrent Element :" + nNode.getNodeName());

    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

        Element eElement = (Element) nNode;

        System.out.println("First Name : " + eElement.getElementsByTagName("firstName").item(0).getTextContent());
        System.out.println("Last Name : " + eElement.getElementsByTagName("lastName").item(0).getTextContent());
        System.out.println("Nick Name : " + eElement.getElementsByTagName("phoneNumber").item(0).getTextContent());

    }
return false;
....