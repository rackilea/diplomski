private static boolean isPandigital(int number) {
    int found = 1, expected = 1;
    for (int n = number; n != 0; n /= 10, expected = (expected << 1) | 1)
        found |= 1 << (n % 10);
    return (found == expected);
}