public class MarkCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(jTable, value, isSelected, hasFocus, row, column);
        if (c instanceof JLabel) {
            JLabel label = (JLabel) c;
            label.setHorizontalAlignment(JLabel.RIGHT);
            Integer mk = Integer.parseInt(value.toString());//this is not very clean
            String text= null;
            if (mk >= 75) {
               text="A";
            } else if (mk < 75 && mk >= 65) {
               text="B";
            } else if (mk < 65 && mk >= 55) {
               text="C";
            } else if (mk < 55 && mk >= 35) {
               text="S";
            } else{
                text="F";
            }
            label.setText(text);
    }
        return c;
    }
}