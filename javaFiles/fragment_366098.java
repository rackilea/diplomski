JFrame frame = new JFrame();
        frame.setTitle("Name of the game");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Defining layouts and panels + giving them layouts
        JPanel pMain = new JPanel();
        frame.getContentPane().add(pMain);
        pMain.setLayout(new BorderLayout());

        JPanel bottomComponentsPanel = new JPanel(new GridBagLayout());

        JPanel pLogin = new JPanel();
        pLogin.setBackground(Color.ORANGE);
        pLogin.setPreferredSize(new Dimension(100, 100));

        JPanel pInfo = new JPanel(new GridBagLayout());
        pInfo.setBackground(Color.ORANGE);
        pInfo.setPreferredSize(new Dimension(70, 70));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridx = 0;
        constraints.gridy = 0;

        bottomComponentsPanel.add(pLogin, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        bottomComponentsPanel.add(pInfo, constraints);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        bottomPanel.add(bottomComponentsPanel);

        pMain.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);