JPanel buttons = new JPanel(new FlowLayout());
buttons.add(new JButton("Roll First Time"));
buttons.add(new JButton("Roll Again"));
buttons.add(new JButton("Let the other player roll"));

JPanel field = new JPanel(new GridBagLayout());
field.add(new JTextField(10));

JPanel main = new JPanel(new BorderLayout());
main.add(buttons, BorderLayout.NORTH);
main.add(field);