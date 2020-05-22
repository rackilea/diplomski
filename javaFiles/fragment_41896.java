public static void main(String[] args) {
    int[] array = {2, 0, -12, 0, 23, 45, -4, -5, 2, 23, 0, 9, -7};
    Arrays.sort(array);
    int index = 0;
    int counter = 1;
    while (index < array.length - 1) {
        if (array[index] == array[index + 1]) {
            counter++;
        } else {
            if (counter > 1) {
                System.out.println("element " + array[index] + " repeats " + counter + " times");
            }
            counter = 1;
        }
        index++;
    }
    if (counter > 1) {
        System.out.println("element " + array[index] + " repeats " + counter + " times");
    }
}