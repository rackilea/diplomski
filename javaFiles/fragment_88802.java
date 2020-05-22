public static void main(String[] args) {
        int number = 45322;
        int sortedNumber = 0;

    /*
     * This loop checks for each digit starting from 9 to 0. 
     * In case of ascending order it should be 0 to 9.
     */
    for (int i = 9; i >= 0; i--) {
        int tmpNumber = number;
        while (tmpNumber > 0) {
            int digit = tmpNumber % 10;
            // Check for the greatest digit in the given number
            if (digit == i) {
                sortedNumber *= 10;
                sortedNumber += digit;
            }
            tmpNumber /= 10;
        }
    }
    System.out.println(sortedNumber); // prints 54322.
}