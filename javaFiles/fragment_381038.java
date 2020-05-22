final JTable table = new JTable(); 
table.getModel().addTableModelListener(new TableModelListener() {
  @Override   
  public void tableChanged(TableModelEvent e) {   
    table.doSomething();
  }
 });