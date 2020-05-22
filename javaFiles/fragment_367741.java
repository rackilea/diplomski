String principalText = PrincipalTextField.getText();
String rateText = RateTextField.getText();
String timeText = TimeTextField.getText();

if(principalText.trim().length == 0 || rateText.trim().length == 0 || timeText.trim().length == 0){
    JOptionPane.showMessageDialog(null, "YOUR_ERROR_MSG", "ERROR_TITLE", JOptionPane.ERROR_MESSAGE);
}