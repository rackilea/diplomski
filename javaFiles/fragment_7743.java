public static int multiplyPolynomials(int n, int m) {
    int result = 0x00000000;
    String ns = Integer.toBinaryString(n);

    for (int i = 0; i < ns.length(); i++) {
        // Read the string the other way round...
        int bitIndex = (ns.length() - i) - 1;
        if (ns.charAt(bitIndex) == '1') {
            /*
             * If there's a 1 at place i, add the value of m left-shifted i
             * places to the result.
             */
            int temp = m;
            // Don't need a loop here, just shift it by "i" places
            temp = temp << i;
            result += temp;
        }
    }
    return result;
}