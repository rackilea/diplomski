Icon icon = new ImageIcon("d:/temp/CheckBox.gif");  
JOptionPane jp = new JOptionPane("Session Expired - Please Re Login"),   
  JOptionPane.INFORMATION_MESSAGE,   
  JOptionPane.WARNING_MESSAGE,   
  icon);  
JDialog dialog = jp.createDialog(null, "Session Expired - Please Re Login");
((Frame)dialog.getParent()).setIconImage(((ImageIcon)icon).getImage());  
dialog.setResizable(true);  
dialog.setVisible(true);