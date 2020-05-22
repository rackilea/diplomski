public static boolean checkValid(String password) {
    boolean valid = true;

    if (password.length() < 8) {
        System.out.println("Password must have at least eight characters.");
        valid = false;
    }
    if(!password.matches("[0-9a-zA-Z]+")) {
        System.out.println("Password must only contain letters and digits.");
        valid = false;
    }

    return valid;
}