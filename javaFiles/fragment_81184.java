...
  Vector data = defaultTableModel.getDataVector();
  synchronized(monitor) {
    Collections.sort(data, new ColumnSorter(colIndex, ascending));
  }
}