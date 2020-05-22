InputMap im = table.getInputMap(JTable.WHEN_FOCUSED);
ActionMap am = table.getActionMap();

im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "DeleteRow");
am.put("DeleteRow", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("Delete row");
        int row = table.getSelectedRow();

        if (row > -1) {

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.removeRow(row);

        }

    }
});