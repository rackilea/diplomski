TextField<BigDecimal> text = new TextField<BigDecimal>(id, model){
    @Override
    public IConverter getConverter(Class<?> type) {
        return new BigDecimalConverter() {
            @Override
            public NumberFormat getNumberFormat(Locale locale) {
                NumberFormat format = super.getNumberFormat(locale);
                format.setGroupingUsed(false);
                return format;
            }
        };
    }
};
text.setType(BigDecimal.class);