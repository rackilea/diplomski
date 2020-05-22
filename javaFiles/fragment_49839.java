final JTextArea output = new JTextArea(" a ");

JButton buttond4  = new JButton();
buttond4.setText("d4");
buttond4.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n = rand.nextInt(4) + 1;
        output.append("You threw d4 and got " + n + "\n");

    }
});