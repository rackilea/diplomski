public static String getValue(Element item, String str) {       
    NodeList n = item.getElementsByTagName(str);        
    return XMLfunctions.getElementValue(n.item(0));
}

 public final static String getElementValue( Node elem ) {
     Node kid;
     if( elem != null){
         if (elem.hasChildNodes()){
             for( kid = elem.getFirstChild(); kid != null; kid = kid.getNextSibling() ){
                 if( kid.getNodeType() == Node.TEXT_NODE  ){
                     return kid.getNodeValue();
                 }
             }
         }
     }
     return "";
 }