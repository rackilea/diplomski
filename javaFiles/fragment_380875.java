private void calculatePensionInformation() {
  double salaryBrutto = Double.parseDouble(bruttoTextField.getText());

  double taxPensRound;
  if (pensionCheckBox.isSelected()) {
    double taxPens = salaryBrutto * TAX_PENS;
    //more code