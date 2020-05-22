try {
    firstNum = new BigDecimal(firstNumber.getText().toString());
} catch (NumberFormatException e) {
    firstNum = null;
}
try {
    secondNum = new BigDecimal(secNumber.getText().toString());
} catch (NumberFormatException e) {
    secondNum = null;
}