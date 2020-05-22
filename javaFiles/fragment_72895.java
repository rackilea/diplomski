Stack<Tag> tagStack = new Stack<Tag>();

public void startElement(String uri, String localName, String qName,
        Attributes attributes)
     if(localName.toLowerCase().equals("parent")){
          tagStack.push(new ParentTag());
     }else if(localName.toLowerCase().equals("tag")){
          if(tagStack.peek() instanceof ParentTag){
               //do your things here only when the parent tag is "parent"
          }
     }
}
public void endElement(String uri, String localName, String qName)
        throws SAXException{
     if(localName.toLowerCase().equals("parent")){
          tagStack.pop();
     }
}