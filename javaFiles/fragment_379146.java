JPanel grid = new JPanel( new GridLayout(0, 2) );
grid.add( b1 );
grid.add( b2 );
grid.add( b3 );
grid.add( b4 );

frame.setLayout( new GridBagLayout() );
frame.add(grid, new GridBagConstraints());