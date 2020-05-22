JTable table = new JTable(model);

TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
table.setRowSorter(rowSorter);

rowSorter.setComparator(0, new Comparator<String>() {
  @Override
  public int compare(String o1, String o2) {
    // etc.
  }

});