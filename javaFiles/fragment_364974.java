list.addComponentListener(new ComponentAdapter() {
    @Override
    public void componentResized(ComponentEvent e) {
        JList list = (JList)e.getComponent();
        list.setFixedCellHeight(list.getVisibleRect().height / list.getModel().getSize());
    }
});