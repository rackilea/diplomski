class StrictNumberFormatter extends javax.swing.text.NumberFormatter {
    @Override
    public Object stringToValue(String text) throws ParseException {
        Object parsedValue = super.stringToValue(text);
        String expectedText = super.valueToString(parsedValue);
        if (! super.stringToValue(expectedText).equals(parsedValue)) {
            throw new ParseException("Rounding occurred", 0);
        }
        return parsedValue;
    }

    public StrictNumberFormatter(NumberFormat nf) {
        super(nf);
    }
}

NumberFormat nf = NumberFormat.getNumberInstance();
nf.setMaximumFractionDigits(2);
nf.setMinimumFractionDigits(2);
JFormattedTextField.AbstractFormatter formatter = new StrictNumberFormatter(nf);
final JFormattedTextField ftf = new JFormattedTextField(formatter);
ftf.setValue(new BigDecimal("1234.50"));