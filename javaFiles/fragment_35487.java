public interface MyInterface {
    default boolean idNameSafe() {
        // Perform your check(s) here using getId() and getName()
    }

    int getId();

    String getName();
}