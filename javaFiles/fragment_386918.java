public class FieldAccessor<O, T> { 
    final Field field; // + private constructor
    public T get(O object) { return (T) field.get(object); } // unsafe, bu we validated this before constructing this accessor
    public static <O, T> FieldAccessor<O, T> create(Class<? super O> definingClass, Class<? super T> fieldClass, String fieldName) {
        Field field = definingClass.getDeclaredField(fieldName);
        if (field.getType() != fieldClass) {
            throw some exception;
        }
        return new FieldAccessor<>(field);
    }