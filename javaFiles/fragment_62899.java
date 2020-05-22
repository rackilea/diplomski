public class Main {

    public enum Enumeration {

        Test(Constants.a, Constants.b); // can refer to constant "a" & "b" static variables

        private final String a;
        private final String b;

        Enumeration(String a, String b) {
            this.a = a;
            this.b = b;
        }
    }

    public static class Constants {

        static String a = "a";
        static String b = "b";
    }
}