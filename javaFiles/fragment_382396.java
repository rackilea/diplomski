public class ShowString {
    public static final void main(String[] args) {
        String password = "\"foo\"";
        int    index, len;

        for (index = 0, len = password.length(); index < len; ++index) {
            System.out.println("[" + index + "]: " + password.charAt(index));
        }
    }
}