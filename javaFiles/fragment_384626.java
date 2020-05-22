InputSource inputSource = new InputSource( new FileInputStream( new File("commentupdate.xml")  ) );

DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
dbf.setNamespaceAware(true);
DocumentBuilder db = dbf.newDocumentBuilder();
Document doc = db.parse( inputSource );
NodeList nodeList = doc.getDocumentElement().getChildNodes();
for (int i = 0; i < nodeList.getLength(); i++) 
{
    if ( nodeList.item(i).getNodeType() == Element.COMMENT_NODE ) 
    {
        Comment comment=(Comment) nodeList.item(i);
        String data = comment.getData();
        if ( data.trim().startsWith( "<Context") )
        {
            data = data.replaceAll("reloadable\\s*=\\s*\"true\"", "reloadable=\"false\"");
            Comment newComment = doc.createComment(data);
            comment.getParentNode().appendChild(newComment);
            comment.getParentNode().removeChild(comment);
        }

    }
}

TransformerFactory tf = TransformerFactory.newInstance();
Transformer transformer = tf.newTransformer();
transformer.setOutputProperty( OutputKeys.METHOD, "xml" );
transformer.setOutputProperty( OutputKeys.OMIT_XML_DECLARATION, "true" );
transformer.setOutputProperty( OutputKeys.INDENT, "yes");
StreamResult sr = new StreamResult( new File( "commentupdate.xml" ) );            
transformer.transform( new DOMSource(doc), sr );