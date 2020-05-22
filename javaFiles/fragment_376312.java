boolean state = false;

JButton b1 = new JButton("Login");
b1.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        // some action to perform
        state = true;
    }
});