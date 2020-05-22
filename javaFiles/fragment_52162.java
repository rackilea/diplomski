private static String RandomBinaryString(int n) {
    String s = new String();

    // Code goes here
    // Create a random binary string of just ones and zeros of length n
    for (int i = 0; i < n; i++) {
        int y = randomOther.UI(0, 1);
        if (y == 0) {
            s += '0';// this line here was changed
        } else {
            s += '1';// and this line here was changed too
        }
    }

    return (s);
}