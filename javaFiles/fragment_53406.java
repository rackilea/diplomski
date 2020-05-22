list.setRenderer(new DefaultListCellRenderer() {
    public Component getCellRendererComponent(Component list, Object model, Object value, int index, boolean isSelected) {
        String t = ((Locations)value).getName();
        return super.getCellRendererComponent(list, model, t, index, isSelected);
    }
 });