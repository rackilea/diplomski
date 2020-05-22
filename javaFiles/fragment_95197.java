JTextPane textPane = new JTextPane();
textPane.setText( "Hello" );

//  Define some character attributes

SimpleAttributeSet green = new SimpleAttributeSet();
StyleConstants.setForeground(green, Color.GREEN);

//  Change attributes on some existing text

StyledDocument doc = textPane.getStyledDocument();
doc.setCharacterAttributes(0, 1, green, false);