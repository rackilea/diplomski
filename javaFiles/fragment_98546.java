Integer fontSizes[] = {10, 12, 14, 16, 18, 20, 22};
fontSizeComboBox = new JComboBox(fontSizes);
....
public void actionPerformed(ActionEvent aE) {

    if (aE.getSource() == okButton) {
        String text; //variable to hold text input from result label
        String fontString = (String)fontTypeComboBox.getSelectedItem();
        int fontSize = (int)fontSizeComboBox.getSelectedItem();
        int temp3 = fontColorComboBox.getSelectedIndex();
        //temporary variables initialized to get selected value from JComboBoxes. 
        text = (textField.getText()); //variable to hold string input from textField

        resultLabel.setText("" + text); //setting the modified text to the resultLabel to display in textField on the GUI

        resultLabel.setFont(new Font(fontString, Font.PLAIN, fontSize));

        if (temp3 == 0) {
            resultLabel.setForeground(Color.BLACK);
        } else if (temp3 == 1) {
            resultLabel.setForeground(Color.RED);
        } else if (temp3 == 2) {
            resultLabel.setForeground(Color.GREEN);
        } else if (temp3 == 3) {
            resultLabel.setForeground(Color.BLUE);
        } //end font color statement

    } else if (aE.getSource() == cancelButton) {
        System.exit(0);
    } //end fontTypeComboBox if statement
}