frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
frame.addWindowListener(new WindowAdapter() {
  public void windowClosing(WindowEvent e) {
    // do whatever else
  }
});