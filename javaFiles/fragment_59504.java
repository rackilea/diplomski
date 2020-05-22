final JButton[] button = new JButton[2];

button[0] = new JButton("");
button[0].setText("dsadsa");
button[0].addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent arg0) {
            button[0].setText("dsaadsdsa"); 
    }
});