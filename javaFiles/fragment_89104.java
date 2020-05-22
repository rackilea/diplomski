public static void main(String[] args) throws Exception {
    // Create a new JTidy instance and set options
    Tidy tidy = new Tidy();
    tidy.setXHTML(true); 

    // Parse an HTML page into a DOM document
    URL url = new URL("http://something.com/something.html");       
    Document doc = tidy.parseDOM(url.openStream(), System.out);

    // Use XPath to obtain whatever you want from the (X)HTML
    XPath xpath = XPathFactory.newInstance().newXPath();
    XPathExpression expr = xpath.compile("//div[@id = 'tt']/text()");
    String text = (String)expr.evaluate(doc, XPathConstants.STRING);
    System.out.println(text); // Text Here
}