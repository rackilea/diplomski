public class ATM {
    private static ATM uniqueInstance = new ATM();
    private ATM(){}
    public static ATM getInstance() {
        return uniqueInstance;
    }
}