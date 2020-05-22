double double1 = -1.0; // invalid!
try {
    double1 = Double.parseDouble(editText1.getText().toString());
} catch(RuntimeException ignored) {
    // NPE or parsing failed, double1 == -1.0
}