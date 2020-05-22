static int getFingerprint(String s)
{
    int result=0;
    for (int i = s.length()-1; i>=0; --i) {
        char c = s.charAt(i);
        if (c>='a' && c<='z')
            result |= 1<<(int)(c-'a');
        else if (c>='A' && c<='Z')
            result |= 1<<(int)(c-'A');
    }
    return result;
}

public static void main(String[] args) {
    String[] arr = new String[]{"velo", "low", "vole", "lovee", "volvell", "lowly", "lower", "lover", "levo", "loved", "love",
        "lovee", "lowe", "lowes", "lovey", "lowan", "lowa", "evolve", "loves", "volvelle", "lowed", "love"};
    String s = "love";

    int fingerprint = getFingerprint(s);

    int matches = 0;
    for (String item : arr) {
        if (getFingerprint(item)==fingerprint)
            ++matches;
    }
    System.out.println(matches);
}