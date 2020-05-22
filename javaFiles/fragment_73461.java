private static int hashString(String s) {
    if (s == null) return 0; // An empty/null string will return 0.

    List<Character> charList = new ArrayList<>(); 
    String lowercase = s.toLowerCase(); // This gets us around case sensitivity

    for (int i = 0; i < lowercase.length(); i++) {
        Character c = Character.valueOf(lowercase.charAt(i));
        if (Character.isWhitespace(c)) continue; // spaces don't count
        charList.add(c); // Note the character for future processing...
    }

    // Now we have a list of Characters... Sort it!
    Collections.sort(charList);
    return charList.hashCode(); // See contract of java.util.List#haschCode
}