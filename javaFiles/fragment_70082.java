NodeList nodeList = doc.getElementsByTagName("QRYRESULT");
for (int i = 0; i < nodeList.getLength(); i++) {
    Element value = (Element) nodeList.item(i);

    String ISSUCCESS = value.getElementsByTagName("ISSUCCESS").item(0).getTextContent();
    System.out.println("ISSUCCESS = " + ISSUCCESS);
}