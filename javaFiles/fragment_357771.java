ActionListener menuListener = new ActionListener() {
  public void actionPerformed(ActionEvent event) {
    System.out.println("Popup menu item ["
        + event.getActionCommand() + "] was pressed.");
  }
};

while(rs1.next()){
  JMenuItem item = new JMenuItem(rs1.getString("name"));
  item.addActionListener(menuListener);
  jPopupMenu1.add(item);
}