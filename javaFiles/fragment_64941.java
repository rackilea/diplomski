public static String getCellValue(String filename, int rowIdx, int colIdx) {
    // search for Table element anywhere in the source
    String tableElementPattern = "//*[name()='Table']";
    // search for Row element with given number
    String rowPattern = String.format("/*[name()='Row' and @ss:Index='%d']", rowIdx) ;
    // search for Cell element with given column number
    String cellPattern = String.format("/*[name()='Cell' and @ss:Index='%d']", colIdx) ;  
    // search for element that has ss:Type="String" attribute, search for element with text under it and get text name
    String cellStringContent = "/*[@ss:Type='String']/*[text()]/text()";  
    String completePattern = tableElementPattern + rowPattern + cellPattern + cellStringContent;

    try (FileReader reader = new FileReader(filename)) {
        XPath xPath = getXpathProcessor();
        Node n = (Node)xPath.compile(completePattern)
        .evaluate(new InputSource(reader), XPathConstants.NODE);
        if (n.getNodeType() == Node.TEXT_NODE) {
            return n.getNodeValue().trim();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

private static XPath getXpathProcessor() {
    // this is where the custom implementation of NamespaceContext is used
    NamespaceContext context = new NamespaceContextMap(
        "html", "http://www.w3.org/TR/REC-html40", 
        "xsl", "http://www.w3.org/1999/XSL/Transform",
        "o", "urn:schemas-microsoft-com:office:office",
        "x", "urn:schemas-microsoft-com:office:excel",
        "ss", "urn:schemas-microsoft-com:office:spreadsheet");
    XPath xpath =  XPathFactory.newInstance().newXPath();
    xpath.setNamespaceContext(context);
    return xpath;
}