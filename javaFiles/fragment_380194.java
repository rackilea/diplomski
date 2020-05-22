static Character.UnicodeScript getScript(String s) {
    if (s.isEmpty()) {
        return null;
    }
    return Character.UnicodeScript.of(s.codePointAt(0));
}