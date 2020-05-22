static boolean hasNumberInRange(String s) {
    Matcher m = Pattern.compile("[-+]?\\d+").matcher(s);
    while (m.find()) {
        int number = Integer.parseInt(m.group());
        if (number <= 26 && number >= 11) {
            return true;
        }
    }
    return false;
}