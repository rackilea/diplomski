NodeList planViews = document.getElementsByTagName("planView");

for (int i = 0; i < planViews.getLength(); i++) {
  Node planView = planViews.item(i);
  for (int j = 0; j < planView.getChildNodes().getLength(); j++) {
    Node n = planView.getChildNodes().item(j);
    if (n instanceof Element) {
      Element e = (Element) n;
      System.out.println("s: " + e.getAttribute("s"));
    }
  }
}