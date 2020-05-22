JTable table = ...;

table.setDefaultRenderer( Avatar.class, new TableCellRenderer() {      
  @Override
  public Component getTableCellRendererComponent( JTable table, Object value, boolean isSelected, 
                                 boolean hasFocus, int row, int column )
  {
    Avatar avatar = (Avatar)value;

    //you might want to think about caching the icon and maybe even the label.
    Icon icon = new ImageIcon(Base64.decode( avatar.getBase64Image() ));
    return new JLabel(avatar.getName(), icon, JLabel.LEFT);
  }
} );