public class MyFieldSetMapper implements FieldSetMapper<String> {
    @Override
    public String mapFieldSet(FieldSet fieldSet) throws BindException {
        String myItem = fieldSet.readString(0);
        return myItem;
    }
}