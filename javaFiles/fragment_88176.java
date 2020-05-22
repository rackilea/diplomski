for (QueryChangeDescription queryChangeDescription : databaseChangeEvent.getQueryChangeDescription()) {
  RowChangeDescription[] rowChangeDescriptions = queryChangeDescription.getTableChangeDescription()[0].getRowChangeDescription();
  for (RowChangeDescription rowChangeDescription : rowChangeDescriptions) {
    handleEvent(rowChangeDescription.getRowid());
  }
}