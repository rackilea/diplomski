public class Example {

private static final boolean ENABLED = false;
private static final boolean SOME_OTHER_CONDITION = false;

    static {
        if (SOME_OTHER_CONDITION) {
            if (ENABLED) {
                System.out.println("Enabled!");
            }
        }
    }
}