public static boolean validateFee(String value) {
    try {
        if (value != null && !value.isEmpty()) {
            Integer.parseInt(value);
        }
        return true;
    } catch (NumberFormatException ne) {
        return false;
    }
}