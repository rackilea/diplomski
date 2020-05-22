DefaultTableModel model = (DefaultTableModel) table.getModel();
    for (int i = 0; i < model.getRowCount(); i++) {
        if (model.getValueAt(i, 0) != null && model.getValueAt(i, 0).toString().contains("@")) {
            model.removeRow(i);
        }
    }