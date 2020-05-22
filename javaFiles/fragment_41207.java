public class ATM {

    private static ATM uniqueInstance;

    private ATM() {}

    public static ATM getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ATM();
        }
        return uniqueInstance;
    }

}