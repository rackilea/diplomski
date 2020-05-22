public static int sumOfSquares(List<Integer> num) {
    if (num.isEmpty()) {
        return 0;
    }
    // Deal with only the initial element
    int hold= num.get(0)*num.get(0);
    // Insert at position 1, right after the squared number
    num.add(1, hold);
    // Truncate two initial numbers, the value and its square:
    return num.get(1) + sumOfSquares(num.subList(2, num.size()));
}