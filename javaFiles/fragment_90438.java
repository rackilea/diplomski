float aa;

try {
    aa = Float.parseFloat(a.getText().toString());
} catch (NumberFormatException nfe) {
    aa = 0;
}