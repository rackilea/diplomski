public class TransformThis implements ErrorListener, ErrorHandler {

    public static void main(String[] args) throws java.lang.Exception {

        TransformThis test = new TransformThis();
        String goodXML;
        String badXML;

       goodXML = "<root><level1>WellFormed</level1></root>";
       System.out.println(test.prettyPrint(goodXML));
       badXML = "<root><level1>Not Well Formed</level1>";
       System.out.println(test.prettyPrint(badXML));
   }

   public String prettyPrint(String xml) throws ParserConfigurationException, SAXException {

       SAXParserFactory parserFactory = SAXParserFactory.newInstance();
       SAXParser parser = parserFactory.newSAXParser();
       parser.getXMLReader().setErrorHandler(this);       
       SAXSource xmlInput = new SAXSource(parser.getXMLReader(), new InputSource(new StringReader(xml)));

       StringWriter stringWriter = new StringWriter();
       StreamResult xmlOutput = new StreamResult(stringWriter);
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       transformerFactory.setAttribute("indent-number", 4);

       try {
           Transformer transformer = transformerFactory.newTransformer();
           transformer.setErrorListener(this);
           transformer.setOutputProperty(OutputKeys.INDENT, "yes");
           transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
           transformer.transform(xmlInput, xmlOutput);
       } catch (Exception ex) {
           System.out.println("My message: " + ex.getMessage());
       }

       return xmlOutput.getWriter().toString();
   }


   @Override
   public void warning(TransformerException exception) throws TransformerException {
       //throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void error(TransformerException exception) throws TransformerException {
      //throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void fatalError(TransformerException exception) throws TransformerException {
       //throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void warning(SAXParseException exception) throws SAXException {
       // Do nothing
   }

   @Override
   public void error(SAXParseException exception) throws SAXException {
       // Do nothing
   }

   @Override
   public void fatalError(SAXParseException exception) throws SAXException {
       // Rethrow the exception
       throw exception;
   }

}