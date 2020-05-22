if(model==null)
    model = new AchievementTableModel(cells, columns);
  else
    model.replace(cells, columns);
  if(table==null) {
    table = new JTable(model);
    table.setFillsViewportHeight(true);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    table.getTableHeader().setReorderingAllowed(false);
    table.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
    table.getColumnModel().setColumnSelectionAllowed(false);
    table.getTableHeader().setResizingAllowed(false);
  } else
    table.setModel(model);

  column = table.getColumn(columns[0]);
  column.setPreferredWidth(25);
  column = table.getColumn(columns[1]);
  column.setPreferredWidth(225);
  column = table.getColumn(columns[2]);
  column.setPreferredWidth(40);
  table.doLayout();

  add(new JScrollPane(table), BorderLayout.CENTER);