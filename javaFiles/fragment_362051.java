//not the real code
for(int i=0; i<model.getRowCount(); i++) {
  model.setRowIndex(i);
  Object row = model.getRowData();
  externalContext.getRequestMap().put(var, row);
  //invoke phase-specific action
  externalContext.getRequestMap().remove(var);
}