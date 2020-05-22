public static int[] iterate(int l, int n) {
    int minNum = (int) Math.pow(10, n - 1);
    int maxNum = (int) Math.pow(10, n) - 1;
    // init array with `l` numbers with `maxNum` value
    int[] numbers = new int[l];
    Arrays.fill(numbers, maxNum);
    // iterate through all combinations of numbers
    while (true) {
        System.out.println(Arrays.toString(numbers)); // for debug only
        // calc multiplication of current combination of numbers
        long mul = 1;
        for (int num : numbers) {
            mul *= num;
        }
        if (isPalindrome(mul)) {
            return numbers; // biggest palindrome found
        }
        // calc next combination of numbers
        boolean allMaxNums = true;
        for (int j = l - 1; j >= 0; --j) {
            --numbers[j];
            if (numbers[j] < minNum) {
                numbers[j] = maxNum; // need to reduce next number, go to the next j
            } else {
                // now all numbers in [minNum, maxNum] bounds
                allMaxNums = false;
                break;
            }
        }
        if (allMaxNums) {
            break; // returned to the initial combination
        }
    }
    return null; // palindrome not found
}

private static boolean isPalindrome(long mul) {
    // your check here
    return false;
}