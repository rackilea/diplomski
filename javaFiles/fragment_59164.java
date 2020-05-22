for (int i = 0; i < items.getLength(); i++) {           
    Node item = items.item(i);
    NodeList properties = item.getChildNodes();
    for (int j = 0; j < properties.getLength(); j++) {
            Node property = properties.item(j);
        String name = property.getNodeName();
        if (name.equalsIgnoreCase("title")) {
             // Store it where you want
             String myTitle = property.getFirstChild().getNodeValue(); 
        }
            if (name.equalsIgnoreCase("year")) {
             String year = property.getFirstChild().getNodeValue(); 
        }
    }
}