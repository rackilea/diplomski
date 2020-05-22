final JTextField WeightField = new JTextField();
// (no action listener required here)

final JButton button = new JButton("Continue");
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        myintc = Double.parseDouble(WeightField.getText());
        calW = myintc*1.5;
        // Remainder of "Proceeding to Payment" code
    }
});