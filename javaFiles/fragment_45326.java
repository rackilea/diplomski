ArrayList<String> a = new ArrayList<String>();
    a.add("apple"); a.add("mango");

    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

    Document doc = docBuilder.newDocument();
    Element root = doc.createElement("Fruits");
    doc.appendChild(root);

    for(String name: a){
        Element fruit = doc.createElement("fruit");
        fruit.appendChild(doc.createTextNode(name)); 
        root.appendChild(fruit);
    }
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(new File("C:\\file.xml"));

    transformer.transform(source, result);