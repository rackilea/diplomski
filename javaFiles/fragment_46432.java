public void createRuleXML() {  
  try {  


   String newXmlPath = "C:\\docwrite\\CreatedRuleXml.xml";          

   DocumentBuilderFactory documentFactory = DocumentBuilderFactory  
     .newInstance();  
   DocumentBuilder documentBuilder = documentFactory  
     .newDocumentBuilder();  

   // define root elements  
   Document document = documentBuilder.newDocument();  
   Element rootElement = document.createElement("Root");  
   document.appendChild(rootElement);  

   // define school elements  
   Element TocHeader = document.createElement("Header");  
   rootElement.appendChild(TocHeader); 

   Element HeaderTag = document.createElement("HeaderTag");
   HeaderTag.appendChild(document.createTextNode("Table Of Contents"));     
   TocHeader.appendChild(HeaderTag);           

   TocHeader.appendChild(getToc(document, "1.Introduction"));          
   TocHeader.appendChild(getToc(document, "2.Basics"));           

   // creating and writing to xml file  
   TransformerFactory transformerFactory = TransformerFactory  
     .newInstance();  
   Transformer transformer = transformerFactory.newTransformer();  
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
   DOMSource domSource = new DOMSource(document);  

   StreamResult streamResult = new StreamResult(new File(newXmlPath));

   transformer.transform(domSource, streamResult);  

   System.out.println("File saved to specified path!");  

  } catch (ParserConfigurationException pce) {  
   pce.printStackTrace();  
  } catch (TransformerException tfe) {  
   tfe.printStackTrace();  
  }  
 }    


private static Node getToc(Document doc,  String tocContent) {
       Element tocHeaderRow = doc.createElement("HeaderRow");

       //create name element
       tocHeaderRow.appendChild(getDetailElements(doc, tocHeaderRow, "Content", tocContent));

       return tocHeaderRow;
   }


//utility method to create text node
private static Node getDetailElements(Document doc, Element element, String name, String value) {
    Element node = doc.createElement(name);
    node.appendChild(doc.createTextNode(value));
    return node;
}