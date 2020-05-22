public static String formatNumber(String phoneNumber) {
    if (phoneNumber.startsWith("1")) {
        phoneNumber = phoneNumber.substring(1);
    }
    return "1-".concat(phoneNumber.substring(0, 3)) //
            .concat("-").concat(phoneNumber.substring(3, 6)) //
            .concat("-").concat(phoneNumber.substring(6));
}