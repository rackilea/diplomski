enum ParserState {
    READING_OBJECT,
    READING_ARRAY
}


public static List<String> extractObjects(String array) throws ParseException {
    ParserState state = ParserState.READING_ARRAY;
    ArrayList<String> result = new ArrayList<String>();
    StringBuilder currentObject = null;
    int i = 0;
    int parenthesisBalance = 0;
    for (char c : array.toCharArray()) {
        switch (c) {
            case '{': {
                if (state == ParserState.READING_ARRAY) {
                    state = ParserState.READING_OBJECT;
                    currentObject = new StringBuilder();
                }
                parenthesisBalance++;
                currentObject.append(c);
                break;
            }
            case '}': {
                if (state == ParserState.READING_ARRAY) {
                    throw new ParseException("unexpected '}'", i);
                } else {
                    currentObject.append(c);
                    parenthesisBalance--;
                    if (parenthesisBalance == 0) {
                        state = ParserState.READING_ARRAY;
                        result.add(currentObject.toString());
                    }
                }
                break;
            }
            default: {
                if (state == ParserState.READING_OBJECT) {
                    currentObject.append(c);
                }
            }
        }
        i++;
    }
    return result;
}