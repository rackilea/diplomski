JPanel innerPanel = new JPanel( new BorderLayout() );
innerPanel.add( textArea, BorderLayout.CENTER );
innerPanel.add( spinner, BorderLayout.SOUTH );

JPanel outerPanel = new JPanel( new BorderLayout() );
outerPanel.add( calcButton, BorderLayout.NORTH );
outerPanel.add( panzerCombo, BorderLayout.WEST );
outerPanel.add( widthCombo, BorderLayout.EAST );
outerPanel.add( innerPanel , BorderLayout.CENTER );