public class ColumnExtracter<T> {
    private final Map<String, Field> fieldsByColumn;

    public ColumnExtracter(Class<T> clazz) {
        this.fieldsByColumn = Stream.of(clazz.getDeclaredFields())
              .filter(field -> field.isAnnotationPresent(Column.class))
              .collect(Collectors.toMap(field -> field.getAnnotation(Column.class).name(), Function.identity()));
    }

    public Field getColumnField(String columnName) {
        return fieldsByColumn.get(columnName);
    }

    public <R> R extract(String columnName, T t, Class<R> clazz) throws IllegalAccessException {
        return clazz.cast(extract(columnName, t));
    }

    public Object extract(String columnName, T t) throws IllegalAccessException {
        return getColumnField(columnName).get(t);
    }
}