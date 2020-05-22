private static class MyCellRenderer extends DefaultListCellRenderer {

    private static final long serialVersionUID = 1L;

    private static final Border SELECTION_BORDER = new LineBorder(UIManager.getColor("List.selectionBackground"));
    private static final Border EMPTY_BORDER = new EmptyBorder(1, 1, 1, 1);

    @SuppressWarnings("rawtypes")
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        setBorder(EMPTY_BORDER);
        if (annotations[index] == null) {

            if (isSelected) {

                setBorder(SELECTION_BORDER);

            }

            c.setBackground(Color.white);
        } else if (annotations[index] == true) {
            c.setBackground(Color.green);
        } else {
            c.setBackground(Color.red);
        }
        return c;
    }
}