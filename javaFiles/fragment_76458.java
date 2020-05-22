XPath xpath = XPathFactory
    .newInstance()
    .newXPath();
Element report = (Element) xpath.evaluate("//report", doc, XPathConstants.NODE);
String id = xpath.evaluate("@id", report);
String title = xpath.evaluate("title", report);
NodeList emails = (NodeList)
              xpath.evaluate("id_email/text()", report, XPathConstants.NODESET);

System.out.println(id);
System.out.println(title);
for(int i=0; i<emails.getLength(); i++) {
  System.out.println(emails.item(i).getTextContent());
}