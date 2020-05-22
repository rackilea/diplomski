threeDigitColumn.setCellFactory(TextFieldTableCell.<RowModel, Double>forTableColumn(new StringConverter<Double>() {
        private final NumberFormat nf = NumberFormat.getNumberInstance();

        {
             nf.setMaximumFractionDigits(3);
             nf.setMinimumFractionDigits(3);
        }

        @Override public String toString(final Double value) {
            return nf.format(value);
        }

        @Override public Double fromString(final String s) {
            // Don't need this, unless table is editable, see DoubleStringConverter if needed
            return null; 
        }
    }));