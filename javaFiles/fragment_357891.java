/*
 * Apparently java.time.format.DateTimeFormatter cannot handling
 * a string pattern with variable number of fractional-second
 * digitit.  This method "canonicalize"  any such component
 * to 3 digits
 */
private String optionalCanonicalizeFractionalSecond(String input) {
    if (!formatPattern.contains("mm:ss[.SSS]")) {
        // no fractional-second component in the pattern
        return input; // no need to make any changes
    }
    Pattern regexPattern = Pattern.compile("^(.*)(\\d\\d:\\d\\d)(\\.\\d+)(.*)$");
    Matcher matcher = regexPattern.matcher(input.trim());
    if (!matcher.matches()) {
        // no fractional-second componet in the input string
        return input;
    }
    String prefix = matcher.group(1);
    String minuteSecondString = matcher.group(2);
    String fractionalSecondString = matcher.group(3);
    String suffix = matcher.group(4);
    String canonFss;
    if (fractionalSecondString.length() == 2) {
        canonFss = fractionalSecondString + "00";           // padding with 00
    } else if (fractionalSecondString.length() == 3) {
        canonFss = fractionalSecondString + "0";            // padding with 0
    } else if (fractionalSecondString.length() == 4) {
        canonFss = fractionalSecondString;                  // as is
    } else if (fractionalSecondString.length() > 4
        && fractionalSecondString.length() <= 10) {
        canonFss = fractionalSecondString.substring(0,4);   // truncate to 3 digits
    } else {
        return input;
    }
    return prefix + minuteSecondString + canonFss + suffix;
}