public static boolean isWordCountsRight(String str, String word, int n) {
if (n == 0) return true;

int index = str.indexOf(word);

if (index != -1) {
    return isWordCountsRight(str.substring(index+1), word, n - 1);
} else {
    return false;
}