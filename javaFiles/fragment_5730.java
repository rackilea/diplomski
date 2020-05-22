//  Define a keyword attribute

SimpleAttributeSet keyWord = new SimpleAttributeSet();
StyleConstants.setForeground(keyWord, Color.RED);
StyleConstants.setBackground(keyWord, Color.YELLOW);
StyleConstants.setUnderline(keyWord, Boolean.TRUE );
StyleConstants.setBold(keyWord, true);

//  Change attributes on some text

StyledDocument doc = textPane.getStyledDocument();
doc.setCharacterAttributes(start, end - start, keyWord, false);