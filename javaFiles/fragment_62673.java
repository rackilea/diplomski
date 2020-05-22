String value= "かな〜"; // (I don't see your character so I added some of my own)
    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document doc = builder.newDocument();
    Element root = doc.createElement("value");
    root.setAttribute("attribute", value);
    doc.appendChild(root);
    DOMSource source = new DOMSource(doc);

    ByteArrayOutputStream outStream = null;
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    StreamResult htmlStreamResult = new StreamResult( new ByteArrayOutputStream() );
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-16");
//  transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes"); // optional
    transformer.transform(source, htmlStreamResult);
    outStream = (ByteArrayOutputStream) htmlStreamResult.getOutputStream();
    String outPut = outStream.toString( "UTF-16" );
    System.out.println(outPut);