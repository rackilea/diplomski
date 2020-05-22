JPanel panel = new JPanel(new MigLayout("hidemode 3, debug, wrap 2", "[r][l, grow]"));
JTextField textField1 = new JTextField("20", 20);
JTextField textField2 = new JTextField("30", 30);
JButton button = new JButton("Button");
panel.add(textField1);
panel.add(textField2);
panel.add(button, "span");