LinkedHashMap<List<String>,List<String>> hm; 
 boolean endElementFlag;

 @Override
public void startDocument()
{
    System.out.println("Document started");
    li_elements = new ArrayList<String>();
    li_values=new ArrayList<String>();
}
 @Override
 public void endDocument()
 {
     System.out.println("Documents ended"+hm.size()); 
     for(Map.Entry m:hm.entrySet())
     {
         System.out.println(m.getKey()+""+m.getValue());
     }

 }

 @Override
 public void startElement(String namespaceURI,String localName,String qname,Attributes atts) throws SAXException
 {

    li_elements.add(qname);

    //System.out.println("Element Started");
    //System.out.println(qname+" added in element list");   
 }
 @Override
 public void endElement(String uri,String localName, String qname)
 {

     if(!li_values.isEmpty())
     {
     System.out.println("Element address list:-"+li_elements+"and Corresponding Value:-"+li_values);

     System.out.println();
     }

         li_elements.remove(li_elements.size()-1);
         li_values.clear();

 }
 @Override
 public void characters(char[] ch, int start, int length)
 {

    String str =  new String(ch,start,length);
    li_values.add(str);
 }