NodeList nodeList = doc.getElementsByTagName("city");
    for (int i = 0; i < nodeList.getLength(); i++) {
        String id = nodeList.item(i).getAttributes().getNamedItem("id").getTextContent();
        //  do something with 'id'
        String cityName = nodeList.item(i).getTextContent();
        //  do something with 'cityName'
    }