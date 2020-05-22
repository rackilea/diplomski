public class UtilDateSimpleValue implements KeyValue{

    private SimpleValue value;

    public UtilDateSimpleValue(SimpleValue value) {
        this.value = value;
    }

    public SimpleValue getValue() {
        return value;
    }

    @Override
    public int getColumnSpan() {
        return value.getColumnSpan();
    }

    ...

    @Override
    public Type getType() throws MappingException {
        final String typeName = value.getTypeName();

        if (typeName == null) {
                throw new MappingException("No type name");
        }

        Type result = new UtilDateUserType();

        return result;
    }
    ...
}