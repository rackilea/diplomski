int indexOf(String str, String sub) {
    if (str.length() < sub.length()) return -1;
    if (str.startsWith(sub)) return 0;
    int res = indexOf(str.substring(1), sub);
    return res < 0 ? res : 1+res;
}