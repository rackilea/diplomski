public static boolean isPalindromic(int i) {
    int len = (int) Math.ceil(Math.log10(i+1));
    for (int n = 0; n < len / 2; n++)
        if ((i / (int) Math.pow(10, n)) % 10 !=
            (i / (int) Math.pow(10, len - n - 1)) % 10)
            return false;
    return true;
}