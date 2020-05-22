static Random rand = new Random();

public static char[] cipherAlphabet(char[] alpha) {

    // copy of alpha
    char[] copy = Arrays.copyOf(alpha, alpha.length);

    // linear time O(n)
    for (int i = 0; i < alpha.length; i += 1) {
        // random index
        int j = rand.nextInt(alpha.length);

        // swap
        char temp = copy[j];
        copy[j] = copy[i];
        copy[i] = temp;

    }

    return copy;
}