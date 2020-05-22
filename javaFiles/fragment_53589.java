public First() {

    JButton btnNewButton = new JButton("New button");
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            Second s = new Second();
            s.startSecond(First.this);  // pass in the First instance
        }
    });
}