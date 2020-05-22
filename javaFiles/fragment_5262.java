public static String modify(String one, String two) {
    Set<Character> uniqueChars = new HashSet<>();

    for (int i = 0; i < two.length(); i++)
        uniqueChars.add(two.charAt(i));

    StringBuilder buf = new StringBuilder(one.length());

    for(int i = 0; i < one.length(); i++)
        buf.append(uniqueChars.contains(one.charAt(i)) ? '*' : one.charAt(i));

    return buf.toString();
}