public class RCellRenderer extends DefaultListCellRenderer {

    String runm = "";

    public RCellRenderer2(String runm) {
        this.runm = runm;
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value.equals(runm)) {
            Color fg = Color.BLACK;
            c.setForeground(fg);
        }

        return c;
    }
}