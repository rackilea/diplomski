class MyConverterImpl implements MyConverter {
    MyConverterImpl() {}
    @Override
    public ConverterOutput apply(final MyDTO input, final String myParam)
            throws MyDTOConversionException {
        return converterOutput;
    }
}