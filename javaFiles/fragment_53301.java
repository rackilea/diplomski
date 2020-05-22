static boolean isFormatValid(String password) {
    CharSequence inputStr = password;
    int length = inputStr.length();
    Set<Character> uniqueChars = new HashSet<Character>();

    for(int i=0; i < length; ++i) {
        uniqueChars.add(inputStr.charAt(i));
    }

    return uniqueChars.size() >= 3;
}