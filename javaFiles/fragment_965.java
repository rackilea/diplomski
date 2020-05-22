JDialog dialog = new JDialog((JFrame) null, "Help", true);
dialog.getContentPane().setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));

JTextArea text = new JTextArea(10, 10);

Color color = new Color(UIManager.getColor("control").getRGB()); // <-- Create a new color

text.setBackground(bg);

dialog.add(text);
dialog.pack();
dialog.setLocationRelativeTo(null);
dialog.setVisible(true);