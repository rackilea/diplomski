public class CustomCheckBox extends JCheckBox {

    private ImageIcon sad;
    private ImageIcon happy;

    public CustomCheckBox() {
        try {
            happy = new ImageIcon(ImageIO.read(getClass().getResource("/Happy.png")));
            sad = new ImageIcon(ImageIO.read(getClass().getResource("/Sad.png")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
            setIcon(happy);
        } else {
            setIcon(sad);
        }
    }

}

public class CustomBooleanCellRenderer extends CustomCheckBox implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Boolean) {
            boolean selected = (boolean) value;
            setSelected(selected);
        }
        return this;
    }

}

public class CustomBooleanCellEditor extends AbstractCellEditor implements TableCellEditor {

    private CustomCheckBox editor;

    public CustomBooleanCellEditor() {
        editor = new CustomCheckBox();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value instanceof Boolean) {
            boolean selected = (boolean) value;
            editor.setSelected(selected);
        }
        return editor;
    }

    @Override
    public Object getCellEditorValue() {
        return editor.isSelected();
    }

}