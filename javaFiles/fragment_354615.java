public double roundDecimal(double val, DecimalFormat dFormat) {
    try {
        return dFormat.parse(dFormat.format(val)).doubleValue();
    } catch (ParseException ex) {
        throw new AssertionError(ex);
    }
}