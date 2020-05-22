NodeList childNodes = parent.getChildNodes();

for(int i = 0; i < childNodes.size(); i++) {
   System.out.println(childNodes.item(i)
                                .getAttributes()
                                .getNamedItem("myAttribute")
                                .getNodeValue());
}