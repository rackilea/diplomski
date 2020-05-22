public static void main (String... args) {

    for (Char char : chars) {
        System.out.println(char);
    }
    int k = 0;
    for (int m = 0; m != M; m++) {
        if (flags[m] != 'B') {
            swap(flags, k++, m);
        }
    }
    for (Char char : chars) {
        System.out.println(char);
    }
}