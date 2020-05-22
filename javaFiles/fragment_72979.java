xmlDoc.appendChild(rootElement);
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    DOMSource source = new DOMSource(xmlDoc);
    StreamResult result = new StreamResult(new File("saved.xml"));

    transformer.transform(source, result);