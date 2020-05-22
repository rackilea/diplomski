private static boolean oneUpper(String str) {
    for (char ch : str.toCharArray()) {
        if (Character.isUpperCase(ch)) {
            return true;
        }
    }
    return false;
}