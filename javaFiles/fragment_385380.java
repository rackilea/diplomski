diagnosisList.setCellRenderer(new DefaultListCellRenderer() {
    private static final long serialVersionUID = 1L;

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
            boolean cellHasFocus) {
        JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        renderer.setText(renderer.getText().toLowerCase()); //something
        return renderer;
    }
});