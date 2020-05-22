jTable1.getTableHeader().addMouseListener(new MouseAdapter() {

    @Override
    public void mouseClicked(MouseEvent e) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setColumnCount(0);
        model.addColumn("Banans");
        model.addColumn("Apples");
        model.addColumn("Pears");
        model.addColumn("Fluffy");
        model.addColumn("Unicorns");
    }

});