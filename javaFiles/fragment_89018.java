Document doc = null;
    Node rootElement = null;
    if (f.exists()) {
        doc = docBuilder.parse("C:/Users/steve/Desktop/xmlemail/Email.xml");
        rootElement = doc.getFirstChild();//

    } else {
        doc = docBuilder.newDocument();// this is difrent
        rootElement = doc.createElement("Contacts");//
        doc.appendChild(rootElement); // this is difrent
    }