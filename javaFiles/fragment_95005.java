NumberFormat format = NumberFormat.getDecimalFormat().overrideFractionDigits(2);

Column<dateiles, Number> column = new Column<dateiles, Number>(new NumberCell(format)) {
    @Override
    public Number getValue(dateiles object) {
        return object.sum;
    }
};