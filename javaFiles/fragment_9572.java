try {
    File inputFile = new File("src/vnx.xml");
    DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    // creating input stream
    Document doc = builder.parse(inputFile );

    //Xpath compiler
    //XPathFactory xpf = XPathFactory.newInstance();
    // XPath xpath = xpf.newXPath();

    //XPath Query
   // XPathExpression expr = xpath.compile("/");
    //Node attributeElement = (Node) expr.evaluate(doc, XPathConstants.NODE);

    //New Node          
    Node childnode=doc.createElement("heat");        
    doc .appendChild(childnode);
    childnode.setTextContent("12-34-56");

    // writing xml file
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    DOMSource source = new DOMSource(doc);
     File outputFile = new File("src/input2.xml");
    StreamResult result = new StreamResult(outputFile );
    // creating output stream
    transformer.transform(source, result);
    } catch (Exception e) {
        e.printStackTrace();
    }