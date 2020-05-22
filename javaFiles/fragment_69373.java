public static Point[] getPoints(String xml) throws Exception {
    DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document doc = db.parse(new InputSource(new StringReader(xml)));
    XPath xpath = XPathFactory.newInstance().newXPath();
    XPathExpression expr = xpath.compile("//polygon[@id='collide']/@points");
    String[] pointsAttr = ((String) expr.evaluate(doc, XPathConstants.STRING)).split("\\p{Space}");
    Point[] points = new Point[pointsAttr.length];
    for (int i = 0; i < pointsAttr.length; ++i) {
        String[] coordinates = pointsAttr[i].split(",");
        points[i] = new Point(Integer.valueOf(coordinates[0]), Integer.valueOf(coordinates[1]));
    }
    return points;
}