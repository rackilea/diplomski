DocumentBuilderFactory dbf   = DocumentBuilderFactory.newInstance();
DocumentBuilder        db    = dbf.newDocumentBuilder();
Document               doc   = db.parse( new File( "build.xml" ));
NodeList               nodes = doc.getElementsByTagName( "target" );
System.err.println( nodes instanceof NodeList );
System.err.println( nodes.item( 0 ) instanceof Node );
System.err.println( nodes.item( 0 ) instanceof Element );