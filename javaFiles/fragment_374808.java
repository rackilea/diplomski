if(listaSegmentos.getLength()>=1) {
    Node nodeseg = listaSegmentos.item(0);
    if (nodeseg.getNodeType() == Node.ELEMENT_NODE) {
        Element el = (Element) nodeseg;
        System.out.println("\nSegment id : " + el.getAttribute("id"));
        System.out.println("height : " + el.getElementsByTagName("height").item(0).getTextContent().replaceAll("\"", ""));
        System.out.println("number_vehicles : " + el.getElementsByTagName("number_vehicles").item(0).getTextContent().trim());
    }
}