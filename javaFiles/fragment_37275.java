public JTree build(String pathToXml) throws Exception {
     SAXReader reader = new SAXReader();
     Document doc = reader.read(pathToXml);
     return new JTree(build(doc.getRootElement()));
}

public DefaultMutableTreeNode build(Element e) {
   DefaultMutableTreeNode result = new DefaultMutableTreeNode(e.getText());
   for(Object o : e.elements()) {
      Element child = (Element) o;
      result.add(build(child));
   }

   return result;         
}