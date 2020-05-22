JPanel grid = new JPanel( new GridLayout(0, 2) );
grid.add( b1 );
grid.add( b2 );
grid.add( b3 );
grid.add( b4 );

JPanel wrapper = new JPanel();
wrapper.add( grid );    
frame.add(wrapper, BorderLayout.CENTER);