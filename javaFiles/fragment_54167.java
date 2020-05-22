Action closeWindow = new AbstractAction("Close Window") {
   @Override public void actionPerformed(ActionEvent e) {
     // window closing code here
   }
 };
 closeWindow.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(
     KeyEvent.VK_W, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));