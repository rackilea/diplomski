String response = " <root>"
                      +"   <Response>  "
                      + "       <NO>1</NO>  "
                      + "       <NAME>John Doe</NAME>  " 
                      + "   </Response>  " 
                      + "   <Response>  "
                      + "       <NO>2</NO>  " 
                      + "       <NAME>Jane Doe</NAME>  " 
                      + "  </Response>  "
                      + "</root>";
    Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(
            new InputSource(new StringReader(response.toString())));

    NodeList nodeList = document.getDocumentElement().getChildNodes();

    for (int i = 0; i < nodeList.getLength(); i++) {
    Node node = nodeList.item(i);
    if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) node;
        if (element.getNodeName().contains("Response")) {
            System.out.println(element.getElementsByTagName("NO").item(0).getTextContent());
            System.out.println(element.getElementsByTagName("NAME").item(0).getTextContent());
        }
    }
}

    //And from this also.....
    for (int i = 0; i < nodeList.getLength(); i++) {
        Element element1 = (Element) nodeList.item(i);
                System.out.println(element.getElementsByTagName("NO").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("NAME").item(0).getTextContent());
    }