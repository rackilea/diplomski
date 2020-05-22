@Override
protected IConverterLocator newConverterLocator() {
    ConverterLocator defaultLocator = new ConverterLocator();

    defaultLocator.set(Color.class, new IConverter<Color>() { 
        @Override
        public Color convertToObject(String value, Locale locale) throws ConversionException {
            try {
                return Color.decode(value);
            } catch (NumberFormatException e) {
                throw new ConversionException("Illegal color format", e);
            }
        }

        @Override
        public String convertToString(Color value, Locale locale) {
            return String.format("#%02x%02x%02x", value.getRed(), value.getGreen(), value.getBlue());
        }
    });

    return defaultLocator;
}