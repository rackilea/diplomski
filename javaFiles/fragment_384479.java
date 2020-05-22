private static boolean contains(char[] arr, char ch) {
    for (char v : arr) {
        if (ch == v) {
            return true;
        }
    }
    return false;
}