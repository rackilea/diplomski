updateXMLAttribute(Document doc , String tag, String attribute, String newValue) {
   NodeList nodes = doc.getElementsByTagName(tag);
   for(int i=0; i<nodes.getLength(); i++) {
       if(nodes.item(i) instanceof Element) {
           Element elem = (Element)nodes.item(i);
           Attr attribute = elem.getAttributeNode(attribute);
           attribute.setValue(newValue);
       }
   }
}