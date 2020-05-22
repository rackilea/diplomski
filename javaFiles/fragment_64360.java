static String template =
           "<!DOCTYPE x [ "
         + "<!ENTITY  % entities SYSTEM \"{0}\"> "
         + "<!ENTITY file SYSTEM \"{1}\" >" + "%entities;" + "]>"
         + "<x>&file;</x>";

 private static String createFromTemplate(File entityFile, File xmlFile) {
     return MessageFormat.format(template, entityFile.getAbsolutePath(),
             xmlFile.getAbsolutePath());
 }

 private static File entityFile = new File(<ENTITYFILE>);

 public Document parse(File f) throws JDOMException, IOException {
     String xml = createFromTemplate(entityFile, f);
     SAXBuilder builder = new SAXBuilder();
     Document doc = builder.build(new StringReader(xml));
     Element e = (Element) doc.getRootElement().getChildren().get(0);
     e.detach();
     Document doc2 = new Document(e);
     return doc2;
 }