public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    int prefixLength = strs[0].length();
    for (int i = 1; i < strs.length; i++) {
        int s = 0;
        while (s < prefixLength
            && s < strs[i].length()
            && strs[0].charAt(s) == strs[i].charAt(s)) {
          ++s;
        }
        prefixLength = s;
    }
    return strs[0].substring(0, prefixLength);
}