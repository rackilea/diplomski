public static int findMaximum(char[] input) {
    int result = 0;
    int first = 0;
    int second = 0;
    while (input[first] == input[second]) {
        second++; // the second index should start from another character
    }
    while (second < input.length) {
        int preSecond = second; // copy second, in need reset first to it
        while (second + 1 < input.length && input[second] == input[second + 1]) {
            second++; // increment second
        }
        result = Math.max(result, second - first + 1);
        if (second < input.length - 1) {
            first = preSecond;
        }
        second++;
    }
    return result;
}