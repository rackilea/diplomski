void actionPerformed(ActionEvent e)
{    //listener for add-button
    int num1 = Integer.parse(textfield1.getText());
    int num2 = Interger.parse(textfield2.getText());
    textField3.setText(String.valueOf( math.add(num1, num2) ) );
}