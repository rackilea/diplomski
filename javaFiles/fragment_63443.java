@Override
public void columnSelectionChanged(ListSelectionEvent e) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            System.out.println(table.getSelectedColumn()); // this is correct
            System.out.println(table.getSelectedRow());  // -1 on first click in JTable
        }
    });
}