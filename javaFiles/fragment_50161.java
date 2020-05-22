public static void main(String[] args) {

    //Odd Numbers
    int[] randomNumbers = new int[25];
    int[] evenNumbers = new int[25];
    int[] oddNumbers = new int[25];
    int k = 0, l = 0;
    for (int index = 0; index < randomNumbers.length; index++) {
        randomNumbers[index] = (int) (Math.random() * 99);
    }
    for (int i = 0; i < 25; i++) {
        if (randomNumbers[i] % 2 == 0) {
            evenNumbers[k] = randomNumbers[i];
            k++;
        } else {
            oddNumbers[l] = randomNumbers[i];
            l++;
        }
    }
}