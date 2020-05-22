public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Solution solution = new Solution();
    int size = scanner.nextInt();
    for (int i = 0; i < size; i++){
        long input = scanner.nextLong();
        BigInteger sums = solution.calculateSum(input);
        System.out.println(sums);
    }
}