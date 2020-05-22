Document doc = Jsoup.parse(input);


NodeTraversor traversor  = new NodeTraversor(new NodeVisitor() {

  @Override
  public void tail(Node node, int depth) {
    if (node instanceof Element) {
        Element e = (Element) node;
        e.removeAttr("class");
        e.removeAttr("style");
    }
  }

  @Override
  public void head(Node node, int depth) {        
  }
});

traversor.traverse(doc.body());
String modifiedHtml = doc.toString();