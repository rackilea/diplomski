public static String next(String s)
{
    int toinc = -1;
    for (int i = 0; i < s.length(); ++i) {
        char c = s.charAt(i);
        if (c < '7') {
            toinc = i;
            if (c != '4') break;
        } else if (c > '7') break;
    }
    char[] outChars;
    // Copy the prefix up to and including the character to be incremented
    if (toinc < 0) {
        outChars = new char[s.length() + 1];
    } else {
        outChars = new char[s.length()];
        for (int i = 0; i < toinc; ++i)
            outChars[i] = s.charAt(i);
        // Increment the character to be incremented
        outChars[toinc] = s.charAt(toinc) >= '4' ? '7' : '4';
    }
    // Fill with 4's.
    for (int i = toinc + 1; i < outChars.length; ++i)
        outChars[i] = '4';
    return new String(outChars);
}