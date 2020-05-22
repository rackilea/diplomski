StringValue sv = new StringValue() {
      @Override
      public String getString(Object value) {
          if (value instanceof MyObject) {
              return .... // use MyObject properties to build a suitable rep
          }
          return TO_STRING.getString(value);
      }    
}
list.setCellRenderer(new DefaultListRenderer(sv));
// a bit of beauty: same rep is re-usable in other collection components
table.setCellRenderer(MyObject.class, new DefaultTableRenderer(sv);
comboBox.setRenderer(list.getCellRenderer());
tree.setTreeCellRenderer(new DefaultTreeRenderer(sv));