JFrame f = new JFrame("Test");
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
TableModel model = new DefaultTableModel(
    new Object[][]{{"Some"}, {"More"}}, new Object[]{"Name"});
final JTable table = new JTable(model);
table.getSelectionModel().setSelectionInterval(0, 1);
f.add(table);
f.add(new JButton(new AbstractAction("Export") {

    @Override
    public void actionPerformed(ActionEvent e) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        table.getTransferHandler().exportToClipboard(
            table, clipboard, TransferHandler.COPY);
        Transferable contents = clipboard.getContents(null);
    }
}), BorderLayout.SOUTH);
f.pack();
f.setLocationRelativeTo(null);
f.setVisible(true);