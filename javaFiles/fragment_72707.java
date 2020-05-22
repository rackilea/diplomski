public class SomeApplicationConverter implements Converter {

    @Override
    @SuppressWarnings("unchecked")
    public boolean canConvert(Class type) {
        if (type.equals(SomeApplication.class)) {
            return true;
        }
        return false;
    }

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer,
            MarshallingContext context) {
        throw new UnsupportedOperationException(
                "Marshalling is not supported yet");
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader,
            UnmarshallingContext context) {
        SomeApplication application = new SomeApplication();
        while (reader.hasMoreChildren()) {
            reader.moveDown();
            String name = reader.getNodeName();
            String value = reader.getValue();
            Field field = new Field(name, value);
            application.addField(field);
            reader.moveUp();
        }
        return application;
    }