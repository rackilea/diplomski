public static int hexToDec(char[] arr) {
    int sum = 0;
    for (char c : arr) {
        int num;
        if ('0' <= c && c <= '9') {
            num = c - '0';
        } else if ('A' <= c && c <= 'F') {
            num = 10 + (c - 'A');
        } else {
            throw new IllegalArgumentException("Invalid character in input: " + c);
        }
        sum *= 16;
        sum += num;
    }

    return sum;
}