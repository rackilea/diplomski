public static void main(String[] args) {
    int[] arry = { 11, 12, 13, 14, 15, 16, 17 };
    int size = 5;

    for (int i = 0; i + size <= arry.length ; i++)

        int sum = 0;
        for (int j = i; j < i + size; j++) {
            sum += arry[j];
            System.out.println(sum);
        }

        System.out.println();
        int average = sum / 5;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}