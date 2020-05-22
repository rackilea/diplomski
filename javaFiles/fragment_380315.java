@SuppressWarnings({ "rawtypes", "unchecked" })
    private <T> T getCustomMarshalledValueSet(T toReturn, Method getter, AttributeValue value) {
    DynamoDBMarshalling annotation = getter.getAnnotation(DynamoDBMarshalling.class);
    Class<? extends DynamoDBMarshaller<? extends Object>> marshallerClass = annotation.marshallerClass();

    DynamoDBMarshaller marshaller;
    try {
        marshaller = marshallerClass.newInstance();
    } catch (InstantiationException e) {
        throw new DynamoDBMappingException("Couldn't instantiate marshaller of class " + marshallerClass, e);
    } catch (IllegalAccessException e) {
        throw new DynamoDBMappingException("Couldn't instantiate marshaller of class " + marshallerClass, e);
    }

    Set<T> set = new HashSet<T>();

    for (String part : value.getSS()) {
        set.add((T) marshaller.unmarshall(getter.getReturnType(), part));
    }

    return (T) set;
}