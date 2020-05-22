int resultsetSize = resultset.getFetchSize();

//init the list 
List<GuiRow> guiRowList = new ArrayList<GuiRow>(resultsetSize);
while (resultset.next()) {
  //get the column values
  String id = resultset.getString("studentId");
  String name = resultset.getString("studentName");
  String course = resultset.getString("course");
  //create the the entry 
  GuiRow guiRow = new GuiRow(id, name, course);
  //add it to the list
  guiRowList.add(guiRow);
}

//now that you have a nice list of rows add them one by one to the container
JPanel container = new JPanel(new GridLayout(resultsetSize, 4));
//further container configuration could be done here ...

for (GuiRow row : guiRowList) {
  container.add(row.getjRadioButton());
  container.add(row.getStudentIdLabel());
  container.add(row.getNameLabel());
  container.add(row.getCourseLabel());
}