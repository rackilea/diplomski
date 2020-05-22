public class EmptyStringToNullConverter extends StringToObject {

    public EmptyStringToNullConverter() {
        super(String.class);
    }

    @Override
    protected Object toObject(String string, Class targetClass) throws Exception {
        return StringUtils.isNotBlank(string) ? string : null;
    }

    @Override
    protected String toString(Object object) throws Exception {
        return object.toString();
    }
}