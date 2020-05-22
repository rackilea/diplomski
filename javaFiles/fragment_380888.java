DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
dbf.setNamespaceAware(true);
DocumentBuilder db = dbf.newDocumentBuilder();

Document doc = db.parse( new File( "input.xml" ) );

XPathFactory xPathFactory = XPathFactory.newInstance();
XPath xpath = xPathFactory.newXPath();

XPathExpression expr = xpath.compile ( "//item/../../..");


Object exprValue = expr.evaluate( doc, XPathConstants.NODE );

if ( exprValue != null && exprValue instanceof Node )
{
    Node weatherNode = (Node)exprValue;

    System.out.println( weatherNode.getNodeName() );
}