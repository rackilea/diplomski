JTextPane text = new JTextPane();
JButton button = new JButton("bold");
button.addActionListener(new StyledEditorKit.BoldAction());

JFrame frame = new JFrame("Styled");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLayout(new BorderLayout());
frame.add(button, BorderLayout.NORTH);
frame.add(text, BorderLayout.CENTER);
frame.setSize(600, 400);
frame.setVisible(true);