public class MainClass {

    public static void main(String... args) {

        // Prepare arguments.
        String foo = args[0];
        Integer bar = Integer.valueOf(args[1]);

        // Do the real work.
        SomeClass someClass = new SomeClass();
        SomeResult someResult = someClass.fuzz(foo, bar);

        // Present result and exit.
        System.out.println(someResult);
        System.exit(0);
    }

}