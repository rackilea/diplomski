for (int i = 0; i < 10; i++) {    
    final JTextField currentField = new JTextField(20);                               
    txtFields[i] = currentField;
    txtFields[i].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             currentField.setHorizontalAlignment(JTextField.CENTER);
         }
    });
}