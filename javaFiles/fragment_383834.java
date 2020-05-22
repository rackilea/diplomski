private void createButton(){
    button = new JButton("Calculate");
    class AddInterestListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            DecimalFormat df = new DecimalFormat("0.00");
            double interest;
            double balance = Double.parseDouble(amountField1.getText());
            double rate = Double.parseDouble(amountField2.getText());
            double years = Double.parseDouble(amountField3.getText());
            StringBuilder sb = new StringBuilder(128);
            for(int i = 0; i < years; i++){
                interest = balance * rate / 100;
                balance = balance + interest;
                sb.append("$" + df.format(balance) + "\n");
            }
            resultArea.setText(sb.toString());
        }
    }

    ActionListener listener = new AddInterestListener();
    button.addActionListener(listener);
}