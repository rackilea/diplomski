private static toLowerCaseIfEmail(String string) {
    try {
        new InternetAddress(string, true);
    } catch (AddressException e) {
        return string;
    }
    int lastAt = string.lastIndexOf('@');
    if (lastAt == -1 
        || string.lastIndexOf(']') > lastAt
        || string.lastIndexOf(')' > lastAt) {
        return string;
    }
    return string.substring(0,lastAt)+string.substring(lastAt).toLowerCase();
}