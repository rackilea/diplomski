private static Document convertStringToDocument(String xmlStr) {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
    DocumentBuilder builder;  
    try {  
        builder = factory.newDocumentBuilder();  
        Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) ); 
        return doc;
    } catch (Exception e) {  
        e.printStackTrace();  
    } 
    return null;
}