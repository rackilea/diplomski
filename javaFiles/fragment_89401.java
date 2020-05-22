public class PasswordFinder {

    private static final String PASSWORD = "zxy";
    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    boolean isPassword(String pass) {
        return (pass.equals(PASSWORD));
    }

    boolean findPassword(String password) {
        while (!isPassword(password)) {
            password = next(password);
        }
        return true;
    }

    /* recursive variant, will require up to (ALPHABET.length^(PASSWORD.length+1)) - 1 recursions */

    boolean findPasswordRecursive(String password) {
        if (isPassword(password)) {
            return true;
        }

        return findPasswordRecursive(next(password));
    }

    private String next(String password) {
        if( password.length() == 0 ) {
            return "" + ALPHABET[0];
        }

        char nextChar = password.charAt(password.length()-1);
        int idx = (nextChar - ALPHABET[0] + 1) % ALPHABET.length;
        if( idx == 0 ) {
            return next(password.substring(0, password.length() - 1)) + ALPHABET[0];
        }

        return password.substring(0, password.length() - 1) + ALPHABET[idx];
    }
}