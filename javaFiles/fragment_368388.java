public class ComboBoxTablePopupSkin<S> extends ComboBoxPopupControl<S> {

    ...

    private static final StringConverter DEFAULT_CONVERTER = new StringConverter() {

        @Override
        public String toString(Object o) {
            return o == null ? null : o.toString();
        }

        @Override
        public Object fromString(String s) {
            throw new UnsupportedOperationException();
        }
    };

    public final StringConverter<S> getConverter() {
        StringConverter<S> converter = converterProperty().get();
        // fix in case the property is set to a null
        return converter == null ? DEFAULT_CONVERTER : converter;
    }