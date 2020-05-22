public static void main(String[] args) throws Exception {
    int[] myArray = {1, 6, 43, 22, 4, 6, 4, 3, 8, 7, 3};
    int targetNumber = 9;
    int index1 = 0;
    int index2 = 0;

    boolean stop = false;
    for (int i = 0; i < myArray.length && !stop; i++) {
        for (int j = i + 1; j < myArray.length && !stop; j++) {
            if (myArray[i] + myArray[j] == targetNumber) {
                stop = true;
                index1 = i;
                index2 = j;
            }
        }
    }
    System.out.println(stop 
            ? "The indexes are " + index1 + " and " + index2
            : "No match found");
}