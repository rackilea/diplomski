public static boolean validateFee(String value) {
    if (value == null || value.isEmpty()) {
        return false;
    }
    try {
        Integer.parseInt(value);
        return true;
    } catch (NumberFormatException ne) {
        return false;
    }
}