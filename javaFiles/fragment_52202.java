Try this

 String nodeValue=null;     
if(eElement!=null && eElement.getElementsByTagName(key)!=null     
 && eElement.getElementsByTagName(key).item(0)!=null ){
 nodeValue = eElement.getElementsByTagName(key).item(0).getTextContent();
}
return nodeValue;