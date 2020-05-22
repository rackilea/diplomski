public class LineOfTextListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        if (value instanceof LineOfText) {

            value = ((LineOfText)value).getLine();

        }

        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

    }

}