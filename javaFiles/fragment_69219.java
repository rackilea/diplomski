private static long numPermutations(char[] arr) {
    long result = factorial(arr.length);
    Map<Character, Integer> counts = countChars(arr);
    for (Integer i : counts.values()) {
        // Note that 1! = 1
        result /= factorial(i);
    }
    return result;
}