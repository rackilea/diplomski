private static Number parse(DecimalFormat df, String input) throws ParseException {
        final ParsePosition position = new ParsePosition(0);
        final Number result = df.parse(input, position);

        if (position.getErrorIndex() != -1) {
            throw new ParseException("could not parse input='" + input + "'", position.getErrorIndex());
        } else if (position.getIndex() < input.length()) {
            throw new ParseException("input='" + input + "' wasnt processed completely", position.getIndex());
        }

        return result;
    }