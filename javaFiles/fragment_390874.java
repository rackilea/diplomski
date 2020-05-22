PanelBoard panelBoard = new PanelBoard(); // with overridden getPreferredSize()

JPanel panelGame = new JPanel( new BorderLayout() );
panelGame.setBorder( new EmptyBorder(5, 5, 5, 5) );
panelGame.add( panelBoard );

frame.add( panelGame );
frame.pack();
frame.setVisible();