XPathExpression exp = xpath.compile("/employees/employee");
NodeList nodeList = (NodeList)exp.evaluate(xmlDocument, XPathConstants.NODESET);
XPathExpression grexp = xpath.compile("payment/income/gr[@code='4']");
XPathExpression amexp = xpath.compile("payment/income/gr[@code='4']/@amount");
for( int i = 0; i < nodeList.getLength(); ++i ){
    Node item = nodeList.item( i );
    Object resexp1 = grexp.evaluate( item, XPathConstants.NODE );
    if( resexp1 != null ){
        String resexp2 = amexp.evaluate( item );
        System.out.println( resexp2 );
    } else {
        System.out.println( "0000" );
    }
}