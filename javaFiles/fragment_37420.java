....
Document doc = builder.parse(is);
    NodeList nodes = doc.getElementsByTagName("list");
    for (int i = 0; i < nodes.getLength(); i++) {
        Element element = (Element) nodes.item(i);
        NodeList name = element.getElementsByTagName("string");
        for (int x = 0; x < name.getLength(); x++) {
            Element line = (Element) name.item(x);
            System.out.println("String: " + getCharacterDataFromElement(line));
        }      
    }
....