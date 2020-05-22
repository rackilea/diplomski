Element xSet = (Element) doc.getElementsByTagName("xxxxxx-Set").item(0);
NodeList xSetTags = xSet.getElementsByTagName("tag3");

for(int i = 0; i < xSetTags.getLength(); i++)    {
    Element tag3 = (Element) xSetTags.item(i);
    System.out.println(tag3.getAttribute("Name"));
}