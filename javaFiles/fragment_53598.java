public static void printCombinations(int[] coins, int amount) {
    printCombinations(coins, new int[coins.length], amount, 0);
}

private static void printCombinations(int[] coins, int[] counts, int amount, int index) {
    if (amount == 0) {
        print(coins, counts, 0, "");
    } else if (amount > 0) {
        printCombinationsLoop(coins, counts, amount, index);
    }
}

private static void printCombinationsLoop(int[] coins, int[] counts, int amount, int index) {
    counts[index]++;
    printCombinations(coins, counts, amount - coins[index], index);
    counts[index]--;
    if (index + 1 < coins.length)
        printCombinationsLoop(coins, counts, amount, index + 1);
}

private static void print(int[] coins, int[] counts, int index, String s) {
    if (counts[index] > 0) {
        if (!s.isEmpty())
            s += "+";
        s += counts[index] + "*" + coins[index];
    }
    if (index + 1 == coins.length)
        System.out.println(s);
    else
        print(coins, counts, index + 1, s);
}