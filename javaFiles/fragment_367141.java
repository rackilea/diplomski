double dInput;
try {
    dInput = Double.parseDouble(currentInput);
catch (NumberFormatException e) {
    doSomethingIntelligent();
}
// Now have dInput which can be passed to `sqrt()`.