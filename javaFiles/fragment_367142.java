double dVal = 0;
try {
    dVal = Double.parseDouble(currentInput);
} catch (NumberFormatException e) {}
dVal = Math.sqrt(dVal);
userInputText.setText(String.valueOf(dVal));