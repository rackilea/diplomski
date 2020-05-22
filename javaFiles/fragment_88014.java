public static boolean isPalindromic(String s, int i, int j) {
    return j - i < 1 || s.charAt(i) == s.charAt(j) && isPalindromic(s,i+1,j-1);
}

public static boolean isPalindromic(int i) {
    String s = "" + i;
    return isPalindromic(s, 0, s.length() - 1);
}