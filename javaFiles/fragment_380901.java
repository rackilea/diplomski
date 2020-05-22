public class Test {

    public static void varargMethod(Object... args) {
        System.out.println("Arguments:");
        for (Object s : args) System.out.println(s);
    }

    public static void main(String[] args) throws Exception {
        varargMethod("Hello", "World", "!");

        String[] someArgs = { "Lorem", "ipsum", "dolor", "sit" };

        // Eclipse warns:
        //   The argument of type String[] should explicitly be cast to Object[]
        //   for the invocation of the varargs method varargMethod(Object...)
        //   from type Test. It could alternatively be cast to Object for a
        //   varargs invocation
        varargMethod(someArgs);

        // Calls the vararg method with multiple arguments
        // (the objects in the array).
        varargMethod((Object[]) someArgs);

        // Calls the vararg method with a single argument (the object array)
        varargMethod((Object) someArgs);
    }
}