public class Main {
    private static void readPassword() {
        char[] password = System.console().readPassword();
    }

    public static void main(String[] args) throws Exception {
        readPassword();
        Thread.sleep(1000 * 3600);
    }
}