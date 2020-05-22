JFrame frame = new JFrame( "Test" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 800, 300 );

        JPanel screen = new JPanel( new GridBagLayout() );
        screen.setBackground( Color.WHITE );
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;

        JPanel panel1 = new JPanel();
        panel1.setBackground( Color.RED );
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        screen.add( panel1, gbc );

        JPanel panel2 = new JPanel();
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel2.setBackground( Color.ORANGE );
        screen.add( panel2, gbc );

        JPanel panel3 = new JPanel();
        panel3.setBackground( Color.BLACK );
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        gbc.gridx = 1;
        gbc.gridy = 1;
        screen.add( panel3, gbc );

        frame.add( screen );
        frame.setVisible( true );