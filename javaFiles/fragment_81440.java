private static void methodCount(int[] array) {
    Arrays.sort(array);
    for (int i = 0; i < array.length; i++) {
        int num1 = array[i];
        int counter = 1;
        for (int j = i + 1; j < array.length; j++) {
            int num2 = array[j];
            if (num1 == num2) {
                counter++;
                i++;
            }
        }
        System.out.println("Number " + num1 + " is counted " + counter + " times!");
    }
}