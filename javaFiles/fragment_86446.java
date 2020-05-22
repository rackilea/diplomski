public void init(int width, int height, String title) {
  // !! pack();
  setVisible(false);
  setResizable(false);
  // !! setLocationRelativeTo(null); // center on screen, but it doesnt work
  setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
  setContentPane(content);
  addWindowListener(eventHandler);

  // !! setSize(width, height);
  setPreferredSize(new Dimension(width, height)); // !!
  pack(); // !!
  setLocationRelativeTo(null); // !!
  setTitle(title);

  initBranch();
}