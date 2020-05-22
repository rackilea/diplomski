private class FacilityElement extends javax.swing.JLabel implements javax.swing.ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if(isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        }
        else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setFont(list.getFont());
        if (value instanceof Facility) { // Try this
            setText(" " + ((Facility) value).getName()); 
        }    
        setOpaque(true);

        return this;
    }

}