public TestTwo() {
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    setLayout(gbl);
    p1.setLayout(gbl);

    gbc = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
            GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(
                  0, 0, 0, 0), 0, 0);
    add(p1, gbc); //add p1 in a GBL too, so it ends up in the northwest corner

    p1.add(b1, gbc);

    gbc.gridy = 1;
    p1.add(b2, gbc);

    setLocationRelativeTo(null);
    setResizable(true);
    setSize(200, 200);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
}