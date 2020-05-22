menuRightClickRectangle.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent event) {
    // TODO: add your own logic here, currently a hardcoded rectangle
    mainContentPanel.addRectangle(new Rectangle(10, 10, 100, 50));
    mainContentPanel.repaint();
  }
});