DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse("put_the_path_to_your_file_here");
doc.getDocumentElement().normalize();

NodeList rules = doc.getDocumentElement().getElementsByTagName("Rule");
for (int i = 0; i < rules.getLength(); ++i) {
  Element rule = (Element) rules.item(i);
  Element triggers = (Element) rule.getElementsByTagName("Triggers").item(0);
  int count = Integer.parseInt(triggers.getAttribute("Count"));
  System.out.println("Count=" + count);
}