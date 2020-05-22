public Object stringToValue(String text) throws ParseException {
    Pattern pattern = getPattern();

    if (pattern != null) {
        Matcher matcher = pattern.matcher(text);

        if (matcher.matches()) {
            return super.stringToValue(text);
        }
        throw new ParseException("Pattern did not match", 0);
    }
    return text;
}