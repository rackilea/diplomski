public String toWellFormed(String xml) throws IOException, SAXException {             
  StringBuilder sb = new StringBuilder(xml);                                                 

  XMLReader reader = XMLReaderFactory.createXMLReader();                                     
  reader.setContentHandler(null);                                                            
  reader.setErrorHandler(null);                                                              

  boolean threw = true;                                                                      
  while (threw)                                                                              
    try {                                                                                    
      reader.parse(new InputSource(new StringReader(sb.toString())));                        
      threw = false;                                                                         
    } catch (SAXParseException ex) {                                                         
      if (ex.getMessage().contains("must be followed by either attribute specifications")) {
        threw = true;
        int line = ex.getLineNumber();                                                       
        int column = ex.getColumnNumber();                                                   
        sb.insert(line * column - 1, ' ');                                                                                                            
      } else                                                                                 
        throw ex;                                                                            
    }                                                                                        

  return sb.toString();                                                                      
}                       

String malformedXml = "<test a='a'b='b'c='c'/>";  
String wellFormedXml = toWellFormed(malformedXml);
"<test a='a'b='b'c='c'/>".equals(wellFormedXml);