addComponentListener(new ComponentAdapter() {
    @Override
    public void componentResized(ComponentEvent e) {
        if (i != null) {
            generateScaledInstance();
        }
    }
});