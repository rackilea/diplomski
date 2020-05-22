@FunctionalInterface
interface MyInterface {

    default boolean authorize(String value) {
        return true;
    }

    boolean equals(Object o);
}