int length;
Object result = xpath.evaluate("//a[contains(@href,'citation_for_view')]", docList.get(0), XPathConstants.NODESET);
NodeList nodes = (NodeList) result;
length = nodes.getLength();
if(length>20){
    length=20;
}

for (int i = 0; i < length; i++) {
    System.out.println(nodes.item(i).getFirstChild().getNodeValue());
}