proveedorCombo.setRenderer( new DefaultListCellRenderer(){

        @Override  
        public Component getListCellRendererComponent(
            JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus)
        {
            super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

                if(value != null){
                 Proveedor proveedor = (Proveedor)value;
                 setText( proveedor.getName());
                }
            return this;
        }
});