String xml = "<root/>";

    DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();

    Document dom1 = db.newDocumentBuilder().parse(new InputSource(new StringReader(xml)));

    System.out.println(dom1.getDocumentElement().getLocalName() == null);

    db.setNamespaceAware(true);

    Document dom2 = db.newDocumentBuilder().parse(new InputSource(new StringReader(xml)));

    System.out.println(dom2.getDocumentElement().getLocalName() == null);