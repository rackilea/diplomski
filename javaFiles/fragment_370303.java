...
    statusBar = new JLabel("  ");
    JLabel someOtherLabel = new JLabel("Some other label!");

    JPanel southPanel = new JPanel(new GridBagLayout());

    GridBagConstraints constraints = new GridBagConstraints();
    constraints.weightx = 1;
    constraints.anchor = GridBagConstraints.WEST;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.insets = new Insets(8,8,8,8);

    southPanel.add(statusBar, constraints);

    constraints.gridy = 1;

    southPanel.add(someOtherLabel, constraints);

    Container cp = getContentPane();
    cp.setLayout(new BorderLayout()); // default layout manager is actually BorderLayout
    cp.add(canvas, BorderLayout.CENTER);
    cp.add(southPanel, BorderLayout.SOUTH);
    ...