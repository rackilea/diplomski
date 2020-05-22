public class ObjectWrapper implements Wrapper {
    private Object wrappedObject;

    public ObjectWrapper(Object wrappedObject) {
        this.wrappedObject = wrappedObject;
    }

    @SuppressWarnings("unchecked")
    public <T> T unwrap(Class<T> paramClass) {
        return (T) wrappedObject;
    }

    public boolean isWrapperFor(Class<?> paramClass) {
        return paramClass.isInstance(wrappedObject);
    }

    public static Wrapper wrap(ResultSet rs, int column, int columnType) throws SQLException {
        if (columnType == 0) {
            return new EmptyListExceptionWrapper();
        } else {
            return new ObjectWrapper(rs.getObject(column));
        }
    }
}