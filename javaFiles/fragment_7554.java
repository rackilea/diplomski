txtDate .addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))        
      {
        JOptionPane.showMessageDialog(null, "Please Enter Valid");
        e.consume();
      }
    }
  });