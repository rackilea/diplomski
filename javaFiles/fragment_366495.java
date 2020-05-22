public boolean isInteger(String str) {
    try {
        Integer.parseInt(str);
    } catch (NumberFormatException e) {
        return false; // The string isn't a valid number
    }
    return true; // The string is a valid number
}