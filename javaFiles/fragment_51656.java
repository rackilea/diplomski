import java.lang.reflect.ParameterizedType;
public abstract class Super<T> {

    protected T object;

    @SuppressWarnings("unchecked")
    public Class<T> getObjectType() {
        // This only works if the subclass directly subclasses this class
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}