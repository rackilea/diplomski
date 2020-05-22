private static void createAndShowGui() {

  Toolbar toolBar = new Toolbar();
  TextPanel textPanel = new TextPanel();

  toolBar.setTextPanel(textPanel);  // ****** passing in my reference *******

  JFrame frame = new JFrame("Add New Lines");
  frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  frame.getContentPane().add(textPanel);
  frame.getContentPane().add(toolBar, BorderLayout.PAGE_START);
  frame.pack();
  frame.setLocationByPlatform(true);
  frame.setVisible(true);
}