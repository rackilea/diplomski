public void decimalConversion(double d) {

    String s = decimal.getText();
    try {
        Integer c = Integer.valueOf(s);
    } catch (NumberFormatException ee) {
        ee.printStackTrace();
    }
}