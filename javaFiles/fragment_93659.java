tabs.addComponentListener(new ComponentAdapter() {
    @Override
    public void componentResized(ComponentEvent e) {
        JTabbedPane tabbedPane = (JTabbedPane) e.getComponent();
        int tabCount = tabbedPane.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            Component c = tabbedPane.getComponentAt(i);
            c.setPreferredSize(new Dimension(c.getSize().width, c.getPreferredSize().height));
        }
    }
});