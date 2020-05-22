JPanel helper = new JPanel(  );
    GridBagLayout gbl_helper = new GridBagLayout();
    gbl_helper.columnWidths = new int[]{200, 7, 200, 60, 18, 0};
    gbl_helper.rowHeights = new int[]{20, 20};
    gbl_helper.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
    gbl_helper.rowWeights = new double[]{0.0, 0};
    helper.setLayout(gbl_helper);

    GridBagConstraints gbc1 = new GridBagConstraints();
    gbc1.fill = GridBagConstraints.HORIZONTAL;
    gbc1.gridwidth = 2;
    gbc1.anchor = GridBagConstraints.NORTHWEST;
    gbc1.insets = new Insets(5,5,5,5);
    gbc1.gridx = 0;
    gbc1.gridy = 0;
    JButton button1 = new JButton( "Add puncta coordinates from CSV" );
    helper.add( button1, gbc1 );

    GridBagConstraints gbc2 = new GridBagConstraints();
    gbc2.fill = GridBagConstraints.HORIZONTAL;
    gbc2.gridwidth = 2;
    gbc2.anchor = GridBagConstraints.NORTHWEST;
    gbc2.insets = new Insets(5,5,5,5);
    gbc2.gridx = 2;
    gbc2.gridy = 0;
    JButton button2 = new JButton( "Add track coordinates from CSV" );

    helper.add( button2, gbc2 );

    GridBagConstraints gbc3 = new GridBagConstraints();
    gbc3.insets = new Insets(0, 0, 0, 5);
    gbc3.gridx = 0;
    gbc3.gridy = 1;
    JLabel label = new JLabel( "Move to time:" );
    helper.add( label, gbc3 );

    JTextField tMoveTime = new JTextField();
    tMoveTime.setColumns(15);
    GridBagConstraints gbc4 = new GridBagConstraints();
    gbc4.anchor = GridBagConstraints.WEST;
    gbc4.insets = new Insets(0, 0, 0, 5);
    gbc4.gridx = 1;
    gbc4.gridy = 1;
    helper.add( tMoveTime, gbc4);

    JButton bMoveTime = new JButton("Move");
    GridBagConstraints gbc5 = new GridBagConstraints();
    gbc5.insets = new Insets(0, 0, 0, 5);
    gbc5.anchor = GridBagConstraints.NORTHEAST;
    gbc5.gridx = 3;
    gbc5.gridy = 1;
    helper.add( bMoveTime, gbc5 );