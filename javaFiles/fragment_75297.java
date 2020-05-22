ArrayList<StudentRecord> StudentDownloads = new ArrayList<StudentRecord>();

for (int i = 0; i < nodes.getLength(); i++) {                           
  Element e = (Element)nodes.item(i);
  int id = Integer.valueOf(XMLfunctions.getValue(e, "StudentId")));
  int type = Integer.valueOf(XMLfunctions.getValue(e, "StudentType")));
  String location = XMLfunctions.getValue(e, "StudentLocation"));
  String mother = XMLfunctions.getValue(e, "StudentMother"));

  StudentRecord newRecord = new StudentRecord(id, type, location, mother);

  StudentDownloads.add(newRecord);
}