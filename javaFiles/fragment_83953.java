String textValue = jtextField.getText();
String twoDoublesRegularExpression = "-?[1-9][0-9]*(\\.[0-9]+)?,\\s*-?[1-9][0-9]*(\\.[0-9]+)?";

if (textValue.matches(twoDoublesRegularExpression)) {
    // this value is OK
}