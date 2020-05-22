// creating the document in-memory                                                        
Document xmldoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

Element element = xmldoc.createElement("TestElement");                                    
xmldoc.appendChild(element);                                                              
element.appendChild(xmldoc.createCDATASection("first line\nsecond line\n"));              

// serializing the xml to a string                                                        
DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();             

DOMImplementationLS impl =                                                                
    (DOMImplementationLS)registry.getDOMImplementation("LS");                             

LSSerializer writer = impl.createLSSerializer();                                          
String str = writer.writeToString(xmldoc);                                                

// printing the xml for verification of whitespace in cdata                               
System.out.println("--- XML ---");                                                        
System.out.println(str);                                                                  

// de-serializing the xml from the string                                                 
final Charset charset = Charset.forName("utf-16");                                        
final ByteArrayInputStream input = new ByteArrayInputStream(str.getBytes(charset));       
Document xmldoc2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(input);

Node vs =  xmldoc2.getElementsByTagName("TestElement").item(0);                           
final Node child = vs.getFirstChild();                                                    
String x = child.getNodeValue();                                                          

// print the value, yay!                                                                  
System.out.println("--- Node Text ---");                                                  
System.out.println(x);