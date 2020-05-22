public static void main(String[] args) throws Exception {
    int sum = 15;
    int[] numbers = new int[] { 1, 2, 3, 4, 5 };

    numbers[4] = 0;
    for (int i = 0; i < numbers.length; i++) {
        sum -= numbers[i];
    }
    System.out.println(sum);
}