@Override
public void endElement(String uri,String localName,String qName) throws SAXException{
        if(localName.equals("item")){inItem = false;}
        if(localName.equals("title")){inTitle = false;}
        if(localName.equals("description")){inDescription = false;}
        if(localName.equals("pubDate")){inDate = false;}
}