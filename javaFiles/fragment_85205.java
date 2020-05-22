Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    document.setXmlStandalone(true);

    Element root = document.createElement("root");
    document.appendChild(root);
    root.appendChild(document.createElement("childElement"));
    document.insertBefore(document.createComment("some comment"), root);

    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");

    transformer.transform(new DOMSource(document), new StreamResult(System.out));