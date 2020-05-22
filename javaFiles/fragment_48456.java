String text = textField[0].getText();
try {
    int textToInt = Integer.parseInt(text);
    ...
} catch (NumberFormatException e) {
    try {
        double textToDouble = Double.parseDouble(text);
        ...
    } catch (NumberFormatException e2) {
        // message?
    }
}