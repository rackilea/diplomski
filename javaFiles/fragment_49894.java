public static String formatNumber(String phoneNumber) {
    if (phoneNumber.startsWith("1")) {
        phoneNumber = phoneNumber.substring(1);
    }
    return phoneNumber.replaceAll("(\\d{3})(\\d{3})(\\d+)", "1-$1-$2-$3");
}