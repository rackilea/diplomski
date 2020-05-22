DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(){
    @Override
    protected void setValue(Object value) {
        setText((value == null || value.toString().equalsIgnoreCase("null")) ? "" : value.toString());
    } 
};
table.setDefaultRenderer(Object.class, renderer);