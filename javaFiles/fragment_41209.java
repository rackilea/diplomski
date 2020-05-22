public class ATM {
    private static ATM uniqueInstance = null;
    private ATM(){}
    public static synchronized ATM getInstance() {
        if ( uniqueInstance == null ) {
            uniqueInstance = new ATM();
        }
        return uniqueInstance;
    }
}