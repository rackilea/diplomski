public class StringToNameConverter implements Converter<String, Name> {

    public Name convertToModel(String text, Locale locale) {
        String[] parts = text.split(" ");
        return new Name(parts[0], parts[1]);
    }

    public String convertToPresentation(Name name, Locale locale)
            throws ConversionException {
        return name.getFirstName() + " " + name.getLastName();
    }

    public Class<Name> getModelType() {
        return Name.class;
    }

    public Class<String> getPresentationType() {
        return String.class;
    }
}