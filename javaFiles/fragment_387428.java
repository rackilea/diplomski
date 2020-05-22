public static void main(String[] args) throws JDOMException, IOException {
    SAXBuilder sb = new SAXBuilder();
    Document doc = sb.build(new StringReader("<document>blabla<bold>test<list><item>hello<italics>dfh</italics></item></list></bold>sdfsd</document>"));

    XMLOutputter xout = new XMLOutputter();
    String txt = xout.outputString(doc.getRootElement().getContent());
    System.out.println(txt);        
}