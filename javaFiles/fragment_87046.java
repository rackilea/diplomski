public GUI() {

    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setExtendedState(window.MAXIMIZED_BOTH);
    window.setVisible(true);
    window.add(mainPanel);
    mainPanel.setLayout(new GridLayout(5, 1));
    mainPanel.setAlignmentY(JComponent.LEFT_ALIGNMENT);

    check[0] = new JCheckBox("red");
    check[1] = new JCheckBox("violet");
    check[2] = new JCheckBox("pink");
    check[3] = new JCheckBox("magenta");
    check[4] = new JCheckBox("every color");

    for (int i = 0; i < 5; i++) {
        mainPanel.add(check[i]);
    }

}