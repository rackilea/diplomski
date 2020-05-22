private void onNumberButtonClicked(ActionEvent event){
    String formerText = textField.getText();
    String additionalText = ((Button)event.getSource()).getText();
    textField.setText(formerText.substring(0, oldCaretPosition)
                        + additionalText
                        + formerText.substring(oldCaretPosition));
}