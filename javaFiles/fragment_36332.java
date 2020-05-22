@MappedSuperclass
public abstract class Generic<T extends Generic> {
    @Transient protected Class<T> entityClass;
    public Generic() {
        Class obtainedClass = getClass();
        Type genericSuperclass = null;
        for(;;) {
            genericSuperclass = obtainedClass.getGenericSuperclass();
            if(genericSuperclass instanceof ParameterizedType) {
                break;
            }
            obtainedClass = obtainedClass.getSuperclass();
        }
        ParameterizedType genericSuperclass_ = (ParameterizedType) genericSuperclass;
        entityClass = ((Class) ((Class) genericSuperclass_.getActualTypeArguments()[0]));
    }