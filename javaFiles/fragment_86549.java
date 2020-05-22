Document doc =...

// write the content into xml file
    DOMSource source = new DOMSource(doc);
    FileWriter writer = new FileWriter(new File("/tmp/output.xml"));
    StreamResult result = new StreamResult(writer);

    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    transformer.transform(source, result);