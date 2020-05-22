JEditorPane editor = new JEditorPane();
editor.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
editor.setText("..large text block..");
JScrollPane scrollPane = new JScrollPane(editor);

JPanel panel = new JPanel();
BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
panel.setLayout(layout);
panel.add(Box.createVerticalGlue());
panel.add(scrollPane);
panel.add(Box.createVerticalGlue());


JFrame frame = new JFrame();
frame.setSize(600, 400);
frame.add(panel);

frame.setVisible(true);