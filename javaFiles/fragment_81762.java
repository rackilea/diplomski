JFrame frame = new JFrame();
JTextArea textArea = new JTextArea("Test");
textArea.setLineWrap(true);
//textArea.setWrapStyleWord(true);
JScrollPane scrollPane = new JScrollPane(textArea);
frame.add(scrollPane);