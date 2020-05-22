System.out.println("\tassd\teventy");
String eventy = null;
for (int i = 0; i < list.getLength(); i++) {
    Element element = (Element)list.item(i);
    String nodeName = element.getNodeName();

    if (nodeName.equals("assd")) {
        System.out.println("\t" + element.getChildNodes().item(0).getNodeValue() + "\t" + eventy);

    } else if (nodeName.equals("eventy")) {
        eventy = element.getChildNodes().item(0).getNodeValue();
    } 
}