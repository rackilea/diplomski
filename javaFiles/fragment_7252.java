public static String charRange(String str) {
    StringBuilder ret = new StringBuilder();
    char ch;
    for(int index = 0; index < str.length(); index++) {
        ch = str.charAt(index);
        if(ch == '\\') {
            if(index + 1 >= str.length()) {
                throw new PatternSyntaxException(
                    "Malformed escape sequence.", str, index
                );
            }
            // special case for escape character, consume next char:
            index++;
            ch = str.charAt(index);
        }
        if(index + 1 >= str.length() || str.charAt(index + 1) != '-') {
            // this was a single char, or the last char in the string
            ret.append(ch);
        } else {
            if(index + 2 >= str.length()) {
                throw new PatternSyntaxException(
                    "Malformed character range.", str, index + 1
                );
            }
            // this char was the beginning of a range
            for(char r = ch; r <= str.charAt(index + 2); r++) {
                ret.append(r);
            }
            index = index + 2;
        }
    }
    return ret.toString();
}