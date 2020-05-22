table.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
            if (table.getSelectedRow() != -1) {
                SwingUtilities.getWindowAncestor(table).dispose();
            }
        }
    }
});