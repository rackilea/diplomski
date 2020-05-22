public static void findRepeating(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int d = 0; d < arr.length; d++) {
            if (i != d && arr[i] / arr[d] == 1 && arr[i] % arr[d] == 0) {
                System.out.println(arr[i] + " is repeating");
            }
        }
    }
}

public static void main(String[] args) {
    int[] myArray = { 69, 7, 8, 9, 90, 666, 69, 420, 2 };
    findRepeating(myArray);
}