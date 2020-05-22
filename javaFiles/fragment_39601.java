public void menu() {
    System.out.println("Menu Ran");
    mainPanel.sidePanel.add(menuPanel);

    mainPanel.sidePanel.validate();  // try this

    menuPanel.repaint();
    mainPanel.repaint();
    mainPanel.sidePanel.repaint();
}