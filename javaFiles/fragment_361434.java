Iterator<?> processDescendants = doc.getDescendants(new ElementFilter()); 

while(processDescendants.hasNext()) {
   Element e =  processDescendants.Next();
   string currentName = e.getTagName();
   if( currentName.equals("a") || currentName.equals("b") )
   {
       numPending++;
   }
}