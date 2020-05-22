String newName = "i";
// parse String as DOM
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
Document doc = db.parse(new InputSource(new StringReader(content)));

// modify DOM
doc.renameNode(doc.getDocumentElement(), null, newName);