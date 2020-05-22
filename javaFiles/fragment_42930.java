public static boolean isValid(String romanNumber) {
    String pattern = "[m|d|c|l|x|v|i]*";
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(romanNumber);

    return m.matches();
}