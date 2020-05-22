NumberFormatter formatter = new NumberFormatter() {
    @Override
    public Object stringToValue(String text)
    throws ParseException {
        try {
            return Double.valueOf(text);
        } catch (NumberFormatException ne) {
            return super.stringToValue(text);
        }
    }
};
JFormattedTextField field = new JFormattedTextField(formatter);
field.setColumns(12);