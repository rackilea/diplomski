// return true if integer has 4 or more of same digit, otherwise false
static boolean check4(int i) {
    int[] charCounts = new int[10];
    for (char c : String.valueOf(i).toCharArray()) {
        if (++charCounts[c-'0'] == 4) return true;
    }
    return false;
}