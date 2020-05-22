jPanelC = new JPanel();
    jlabel1 = new JLabel("User ID");
    jlabel2 = new JLabel("Password");
    jid = new JTextField(15);
    // jid.setPreferredSize(new Dimension(100, 100));
    jpass = new JPasswordField(15);
    // jpass.setPreferredSize(new Dimension(100, 100));
    jbutton1 = new JButton("Login");
    // jbutton1.setPreferredSize(new Dimension(100, 100));

    jPanelC.setBackground(new java.awt.Color(204, 204, 255));
    jPanelC.setBorder(empty);
    int eb = 5;
    jPanelC.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(eb, eb, eb, eb), // outer
                                                                                                            // border
            BorderFactory.createLoweredBevelBorder())); // inner border
    jPanelC.setSize(300, 150);

    jPanelC.setLayout(new GridBagLayout());

    panelU = new JPanel(new GridBagLayout());
    panelU.setBackground(new java.awt.Color(204, 204, 255));

    GridBagConstraints c = new GridBagConstraints();

    c.fill = GridBagConstraints.NONE;
    c.anchor = GridBagConstraints.CENTER;
    c.gridx = 0;
    c.gridy = 0;
    c.weightx = 1.0;
    c.weighty = 1.0;
    c.insets = new Insets(5, 5, 5, 5);
    panelU.add(jlabel1, c);

    c.fill = GridBagConstraints.NONE;
    c.anchor = GridBagConstraints.CENTER;
    c.gridx = 2;
    c.gridy = 0;
    c.weightx = 1.0;
    c.weighty = 1.0;
    c.insets = new Insets(5, 5, 5, 5);
    panelU.add(jid, c);

    c.fill = GridBagConstraints.NONE;
    c.anchor = GridBagConstraints.CENTER;
    c.gridx = 0;
    c.gridy = 1;
    c.weightx = 1.0;
    c.weighty = 1.0;
    c.insets = new Insets(5, 5, 5, 5);
    panelU.add(jlabel2, c);

    c.fill = GridBagConstraints.NONE;
    c.anchor = GridBagConstraints.CENTER;
    c.gridx = 2;
    c.gridy = 1;
    c.weightx = 1.0;
    c.weighty = 1.0;
    c.insets = new Insets(5, 5, 5, 5);
    panelU.add(jpass, c);

    c.fill = GridBagConstraints.CENTER;
    c.anchor = GridBagConstraints.CENTER;
    c.gridx = 0;
    c.gridy = 2;
    c.insets = new Insets(5, 5, 5, 5);
    c.gridheight = 1;
    c.gridwidth = 2;

    GridBagConstraints c1 = new GridBagConstraints();

    c1.gridx = 0;
    c1.gridy = 0;
    c1.gridwidth = 1;
    c1.gridheight = 1;
    c1.weightx = 0.0;
    c1.weighty = 0.0;
    c1.insets = new Insets(5, 5, 5, 5);
    c1.fill = GridBagConstraints.NONE;
    c1.anchor = GridBagConstraints.CENTER;

    jPanelC.add(panelU, c1);

    c1.gridx = 0;
    c1.gridy = 1;
    c1.gridwidth = 1;
    c1.gridheight = 1;
    c1.weightx = 0.0;
    c1.weighty = 0.0;
    c1.insets = new Insets(5, 5, 5, 5);
    c1.fill = GridBagConstraints.NONE;
    c1.fill = GridBagConstraints.CENTER;

    jPanelC.add(jbutton1, c1);

    jPanelE = new JPanel();
    jPanelW = new JPanel();
    jPanelN = new JPanel();
    jPanelS = new JPanel();
    add(jPanelE, BorderLayout.EAST);
    add(jPanelW, BorderLayout.WEST);
    add(jPanelN, BorderLayout.NORTH);
    add(jPanelS, BorderLayout.SOUTH);
    add(jPanelC, BorderLayout.CENTER);

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Login Console");
    setBackground(new java.awt.Color(255, 255, 255));
    setSize(400, 300);
    this.setVisible(true);