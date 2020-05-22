public class IconTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    protected void setValue(Object value) {
        if (value instanceof Icon) {
            setText(null);
            setIcon((Icon) value);
        } else {
            super.setValue(value);
        }
    }
}