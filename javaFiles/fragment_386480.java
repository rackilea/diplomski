@FunctionalInterface
interface MyInterface {

    boolean authorize(int val);

    default boolean authorize(String value) {
        return true;
    }
}