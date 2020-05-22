public void write(String name) {
    try {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();            
        Document document = db.newDocument();

        Element blobKey_E = document.createElement("first-name");
        blobKey_E.appendChild( document.createTextNode( name ) );

        /*
         * Here blobKey_E is treated as the root element for the document that you've created
         */
        document.appendChild(blobKey_E); 
//            // LINE 27 
//            document.getDocumentElement().appendChild(blobKey_E); // append the new tag under the root

        /*
         * Post this point, if you do a document.getDocumentElement(), it will no longer return 
         * a nullpointerexception because blobKey_E will be treated as the root element.
         */

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File("/home/non-admin/NetBeansProjects/Personal Site_Testers/web/xml/xml_1.xml"));
        transformer.transform(source, result);            
    }catch(Exception exc) {
        exc.printStackTrace();
    }
}