list.addMouseListener(new MouseAdapter() {
    @Override
    public void mousePressed(MouseEvent e) {
        JList list = (JList)e.getComponent();
        if (SwingUtilities.isRightMouseButton(e)) {
            int row = list.locationToIndex(e.getPoint());
            list.setSelectedIndex(row);
        }
    }
});