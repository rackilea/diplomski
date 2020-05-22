float from_value;
try {
    from_value = Float.parseFloat(editText2.getText().toString());
}
catch(NumberFormatException ex) {
    from_value = 0.0; // default ??
}