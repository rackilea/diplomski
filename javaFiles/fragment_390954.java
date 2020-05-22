col_age.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Number>() {

    @Override
    public String toString(Number value) {
        return value == null ? "" : value.toString();
    }

    @Override
    public Number fromString(String value) {
        return (value == null) ? null : Integer.parseInt(value);
    }

}));