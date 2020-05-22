public class Application {
    public static void main(String[] args) {
        String newFoo = "Scrum";
        boolean match = newFoo.matches("\\p{Alpha}{3}");
        checkArgument(
            match,
            "Foo must have exactly 3 characters!"
        );
        checkArgument(
            newFoo.matches("\\p{Alpha}{3}"),
            "Foo must have exactly 3 characters!"
        );
    }

    private static void checkArgument(boolean status, String errorMessage) {
        if (!status)
            System.out.println(errorMessage);
    }
}