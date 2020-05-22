public class Imp<T> extends AbstractClass<T> {

    public Imp() {
        super(null); // you need to call an existing constructor from superclass (nothing specific about generic classes)
    }

    public Imp(Class<T> entityClass) {
        super(entityClass);
    }
}