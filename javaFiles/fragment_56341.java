public boolean valide(String filename) throws JDOMException, IOException
{ 
        SAXBuilder builder = new SAXBuilder();  
        try{
                 Document doc = builder.build(new File(filename));     
               } catch (JDOMParseException ex) {
                 return false;
                }
         return true;
}