String tagName = null;
public void startElement(String uri, String localName, String qName,
        Attributes attributes)
     if(localName.toLowerCase().equals("parent")){
          tagName = "parent";
     }else if(localName.toLowerCase().equals("tag")){
          if(tagName!= null && tagName.equals("parent")){
               //do your things here only when the parent tag is "parent"
          }
     }
}
public void endElement(String uri, String localName, String qName)
        throws SAXException{
     tagName = null;
}