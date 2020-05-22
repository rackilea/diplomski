public class ItemSelector<T> {
    private final Class<T> clazz;
    public ItemSelector(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void test(GameObject ob) {
        if (clazz.isInstance(ob)) {// use token to check type
            // do work
        }
    }
}