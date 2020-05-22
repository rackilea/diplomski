/**
 * The Interface IX.
 */
public static interface IX {

    /**
     * Gets the list.
     *
     * @return the list
     */
    List<Object> getList();

    /**
     * Adds the value.
     *
     * @param o the o
     */
    default void addValue(Object o) {
        this.getList()
            .add(o);
    }

}

/**
 * The Class AbstractIX.
 */
public static abstract class AbstractIx implements IX {

    /** The list. */
    protected List<Object> list = new ArrayList<>();

    @Override
    public List<Object> getList() {
        return this.list;
    }
}

/**
 * The Class A.
 */
public static class A extends AbstractIx {
    // no addValue implementation here
}

/**
 * The Class B.
 */
public static class B extends AbstractIx {
    // no addValue implementation here
}

/**
 * The Class Main.
 */
public static class Main {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.addValue(1);
        a.addValue(2);

        b.addValue(1);
        System.out.println("List a size should be 2: " + a.getList()
            .size());
        System.out.println("List b size should be 1: " + b.getList()
            .size());
    }
}