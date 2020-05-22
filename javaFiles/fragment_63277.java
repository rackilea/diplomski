File fXmlFile = new File("C:\\DevelopmentTools\\3.CODE\\SOAP.txt");
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(fXmlFile);
doc.getDocumentElement().normalize();

XPath xpath = XPathFactory.newInstance().newXPath();
String responseStatus = xpath.evaluate("//*[local-name()='code']/text()", doc);
String responseText = xpath.evaluate("//*[local-name()='text']/text()", doc);
System.out.println("---> " + responseStatus);
System.out.println("---> " + responseText);