public static String dateFormatToRegex(Locale locale) {
    StringBuilder regex = new StringBuilder();
    String fmt = ((SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT, locale)).toPattern();
    for (Matcher m = Pattern.compile("[^a-zA-Z]+|([a-zA-Z])\\1*").matcher(fmt); m.find(); ) {
        String part = m.group();
        if (m.start(1) == -1) { // Not letter(s): Literal text
            regex.append(Pattern.quote(part));
        } else {
            switch (part.charAt(0)) {
                case 'G': // Era designator
                    regex.append("\\p{L}+");
                    break;
                case 'y': // Year
                    regex.append("\\d{1,4}");
                    break;
                case 'M': // Month in year
                    if (part.length() > 2)
                        throw new UnsupportedOperationException("Date format part: " + part);
                    regex.append("(?:1[0-2]|0?[1-9])");
                    break;
                case 'd': // Day in month
                    regex.append("(?:3[01]|[12][0-9]|0?[1-9])");
                    break;
                default:
                    throw new UnsupportedOperationException("Date format part: " + part);
            }
        }
    }
    return regex.toString();
}