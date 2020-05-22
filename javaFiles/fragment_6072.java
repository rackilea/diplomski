public class RandomSend extend javax.swing.JFrame {
    // This should be preferred for values that can mutate (non-final) to prevent
    // modification without the owning class being alerted the value is changing
    private static String userGender;

    public static void setUserGender(String value) {
        userGender = value;
    }

    public static String getUserGender() {
        return userGender;
    }
}