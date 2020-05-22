public Hangman() {
    Container c = getContentPane();
    c.setBackground(Color.BLACK);
    JTextField input = new JTextField(20);
    c.setLayout(new BorderLayout());
    c.add(input, BorderLayout.SOUTH);
}