private static int countPositive(int[] array) {

    int positive = 0;
    for (int i = 0; i < array.length; i++) {
        if (array[i] > 0) { //should be greater than 0  
            positive++;
        }
    }
    return positive;
}

public static void main(String args[]) {
    int[] array = new int[]{5, 6, 7, 45, -2, -9};
    int count = countPositive(array);
    System.out.println(count);
}