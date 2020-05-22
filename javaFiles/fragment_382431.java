private static toLowerCaseIfEmail(String string) {
    try {
        new InternetAddress(string, true);
    } catch (AddressException e) {
        return string;
    }
    if (string.trim().endsWith("]")) {
        return string;
    }
    int lastAt = string.lastIndexOf('@');
    if (lastAt == -1) {
        return string;
    }
    return string.substring(0,lastAt)+string.substring(lastAt).toLowerCase();
}