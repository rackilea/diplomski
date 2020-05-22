// Register scope as "runtime"
public class RuntimeScope implements Scope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        return objectFactory.getObject();
    }

    ...
}