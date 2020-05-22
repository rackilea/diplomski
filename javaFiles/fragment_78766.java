JEditorPane editor = new JEditorPane();
editor.setContentType("text/html");
editor.getDocument().putProperty("IgnoreCharsetDirective", true);
editor.setText(html);
editor.setEditable(false);

JScrollPane pane = new JScrollPane(editor);
JFrame f = new JFrame("charset=windows-1252");
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.getContentPane().add(pane);
f.setSize(800, 600);
f.setVisible(true);