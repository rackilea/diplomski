public static void main(String... ignored) {
    String s = "116738484849595836625273748485838625252737485884625292837367283849484726373884848484636377473636252626736363636637373747";
    NavigableSet<String> set = new TreeSet<>();
    for(int i=0;i<s.length();i++)
        set.add(s.substring(i));
    String prev = "", longest = "";
    for (String t : set) {
        int len = startMatchingLength(prev, t);
        if (len > longest.length())
            longest = t.substring(0, len);
        prev = t;
    }

    System.out.println("Longest match was " + longest);
}

public static int startMatchingLength(String s, String t) {
    for (int i = 0; i < s.length() && i < t.length();i++)
        if (s.charAt(i) != t.charAt(i))
            return i;
    return Math.min(s.length(), t.length());
}