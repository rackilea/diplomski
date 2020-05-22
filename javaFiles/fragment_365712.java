static int sumRounded(int... nums) {
    int sum = 0;
    for (int num : nums) {
        sum += checkRound(num);
    }
    return sum;
}