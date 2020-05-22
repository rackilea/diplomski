for (int i = 0; i < 10; i++) {                             
    txtFields[i] = new JTextField(20);
    txtFields[i].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             ((JTextField) e.getSource()).setHorizontalAlignment(JTextField.CENTER);
         }
    });
}