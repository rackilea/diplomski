if (hello.equals("hey")) {
     JOptionPane pane = new JOptionPane();
     JDialog dialog = pane.createDialog("My Test");
     pane.setMessage("Hello There");
     dialog.setAlwaysOnTop(true);
     dialog.setVisible(true);
}