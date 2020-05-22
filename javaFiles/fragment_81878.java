double w;

try {
    w = new Double(input3.getText().toString());
} catch (NumberFormatException e) {
    w = 0; // your default value
}