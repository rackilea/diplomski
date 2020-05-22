public DefaultTableModel createModel(List<List<String>> list, String[] columnNames) {

    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    for (List<String> row : list) {
        model.addRow(row.toArray());
    }

    return model;
}