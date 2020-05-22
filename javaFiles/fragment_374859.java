for(int i = 0; i < selectedRows.length; i++){
  @SuppressWarnings("rawtypes")
  Vector targetRow = (Vector)data.elementAt(selectedRows[i]);
  Vector newVector = new Vector();
  for (int t = 0; t < targetRow.size(); t++) {
     newVector.add(targetRow.get(t));
  }
  dtm.insertRow(insertPoint, newVector);
  insertPoint++;
}