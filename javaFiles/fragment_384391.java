public static boolean hasNonWordCharacter(String s) {

    int offset = 0, strLen = str.length();
    while (offset < strLen) {
        int curChar = str.codePointAt(offset);
        offset += Character.charCount(curChar);
        if (!Character.isLetter(curChar)) {
            return true;
        }
    }

    return false;
}