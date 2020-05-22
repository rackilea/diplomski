String name="Guido";
    FileInputStream fileIS = new FileInputStream("C:/Users/Maxi/workspace/ProyectoIteraciones/src/com/proyecto/init/Employees.xml");
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = builderFactory.newDocumentBuilder();
    Document xmlDocument = builder.parse(fileIS);
    XPath xPath = XPathFactory.newInstance().newXPath();        
    String expression = "//Employee/Name[contains(.,'"+name+"')]";      
    NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
    System.out.println("El resultado es "+nodeList.item(0).getTextContent());