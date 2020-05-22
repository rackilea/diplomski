table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedRow = table.convertRowIndexToModel(table.getSelectedRow());
        if (selectedRow > -1) {
            DefaultTableModel newModel = new DefaultTableModel();
            String rowName = "Row: " + selectedRow;
            newModel.setColumnIdentifiers(new Object[]{rowName});
            for (int i = 0; i < model.getColumnCount(); i++) {
                newModel.addRow(new Object[]{model.getValueAt(selectedRow, i)});
            }
            JTable newTable = new JTable(newModel) {
                @Override
                public Dimension getPreferredScrollableViewportSize() {
                    return new Dimension(140, 240);
                }
            };
            // Apply any custom renderers and editors
            JOptionPane.showMessageDialog(f, new JScrollPane(newTable),
                rowName, JOptionPane.PLAIN_MESSAGE);
        }
    }
});