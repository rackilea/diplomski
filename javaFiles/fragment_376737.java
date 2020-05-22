btnSubmit.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        if(textField.getText().isEmpty()||(textField_1.getText().isEmpty())||(textField_2.getText().isEmpty())||(textArea_1.getText().isEmpty())||((radioButton_1.isSelected())&&(radioButton.isSelected()))||(comboBox.getSelectedItem().equals("Select")))
            JOptionPane.showMessageDialog(null, "Data Missing");
        else {
         JOptionPane.showMessageDialog(null, "Data Submitted");
         BufferedWriter writer = new BufferedWriter(new 
         FileWriter(new File("file.txt"), append)); 
         writer.write(textField.getText());
         writer.close();
        }
});