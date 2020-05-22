JTextPane textPane = new JTextPane();
textPane.setContentType( "text/html" );
textPane.setEditable(false);
HTMLDocument doc = (HTMLDocument)textPane.getDocument();
HTMLEditorKit editorKit = (HTMLEditorKit)textPane.getEditorKit();
String text = "<a href=\"abc\">hyperlink</a>";
editorKit.insertHTML(doc, doc.getLength(), text, 0, 0, null);