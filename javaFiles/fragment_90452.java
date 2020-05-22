public static Map<Character, Integer> charCount (String s) {
    Map<Character, Integer> result = new HashMap<>();
    for (int i = 0; i < s.length(); ++i) {
        Character c = s.charAt(i);
        Integer cnt = result.get(c);
        if (cnt == null) {
            cnt = 1;
        } else {
            cnt = cnt + 1;
        }
        result.put (c, cnt);
    }
    return result; 
}

public static boolean stringScramble(String myString1, String myString2)
    return charCount(myString1).equals(charCount(myString2));
}