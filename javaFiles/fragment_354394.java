btnAddCash.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        stats.cash = (stats.cash + 5000);    
        lblCash.setText("Cash: " +stats.cash);  // ****** update the text
    }
});