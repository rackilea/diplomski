JButton btnAddCash = new JButton("ADD 10,000");
btnAddCash.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        stats.cash = (stats.cash + 5000); //     (A)
    }
});

JLabel lblCash = new JLabel("Cash: " +stats.cash); //     (B)