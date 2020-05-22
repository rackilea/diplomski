InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(yourXmlfromTable));
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(is);

        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("header");;

       for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
             String id= element.getAttribute("id");
             System.out.println(id);
             String name =  element.getAttribute("name");
             System.out.println(name);
             String title =  element.getAttribute("title");
             System.out.println(title);
         }
    }