FileInputStream xml = new FileInputStream("original.xml");  
FileInputStream xsl = new FileInputStream("converter.xsl");
StringWriter writer = new StringWriter();

Source xmlDoc =  new StreamSource(xml);
Source xslDoc =  new StreamSource(xsl);
Result result =  new StreamResult(writer);

TransformerFactory factory = TransformerFactory.newInstance();            
Transformer trans = factory.newTransformer(xslDoc);
trans.transform(xmlDoc, result); 

String outputString = writer.toString();