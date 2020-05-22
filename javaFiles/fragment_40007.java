HTMLEditorKit kit = new HTMLEditorKit();
StyleSheet styleSheet = kit.getStyleSheet();
styleSheet.addRule("a:hover{color:red;}");
Document doc = kit.createDefaultDocument();
String htmlString = "<a href='stackoverflow.com'>Go to StackOverflow!</a>";
// your JEditorPane
jEditorPane.setDocument(doc);
jEditorPane.setText(htmlString);