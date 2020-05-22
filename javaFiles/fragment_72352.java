public class CountryEditor extends PropertyEditorSupport {
    @Override
    public void setValue(Object value) {
        super.setValue(value);
    }

    public String getAsText() {
        if (getValue() == null) return null;
        return ((Country) getValue()).getName();
    };

    public void setAsText(String text) throws IllegalArgumentException {
        if (text != null) {
            Country country = // something like filterService.getCountryById(text);
            setValue(country);
        }
    };
}