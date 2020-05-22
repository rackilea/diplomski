public boolean passwordCheck(String password) {
    if (password != null && password.length() >= 8) {
        for (char ch : password.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }
        }
        return true;
    }
    return false;
}