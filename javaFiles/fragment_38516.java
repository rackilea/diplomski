Builder builder = new Builder();
InputStream ins = ReadXML.class.getClassLoader()
      .getResourceAsStream("student_list.xml");

//Reads and parses the XML
Document doc = builder.build(ins);
Element root = doc.getRootElement();

IndexedContainer container = new IndexedContainer();
container.addContainerProperty("name", String.class, null);
container.addContainerProperty("age", Integer.class, null);
//Get children
Elements students = root.getChildElements();
for (int i = 0 ; i < students.size() ; i ++) {
  System.out.println(" Child : " + students.get(i).getLocalName());
  Object student = container.addItem();
  Item studentItem = container.getItem(student);

  //Get first child with tag name as 'name'
  Element nameChild = students.get(i).getFirstChildElement("name");
  if (nameChild != null) {
    studentItem.getItemProperty("name").setValue(nameChild.getValue());
  }
  Element ageChild = students.get(i).getFirstChildElement("age");
  if (ageChild != null) {
      studentItem.getItemProperty("age").setValue(ageChild.getValue());
  }
}