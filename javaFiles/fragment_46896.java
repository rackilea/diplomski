HTMLEditorKit kit = new HTMLEditorKit();
jEditorPane.setEditorKit(kit);
StyleSheet styleSheet = kit.getStyleSheet();
styleSheet.addRule("body {color:#000; font-family:times; margin: 4px; }");
styleSheet.addRule("h1 {color: blue;}");
styleSheet.addRule("h2 {color: #ff0000;}");
styleSheet.addRule("pre {font : 10px monaco; color : black; background-color : #fafafa; }");