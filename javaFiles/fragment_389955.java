int[] numbers = {10,11,9,5,5,3,2,2,1};

public static int countSingles(int[] numbers) {
    // Avoid NPE
    if (numbers == null) {
        return -1;
    }

    int count = 0;

    // Loop the numbers once
    for (int i = 0; i < numbers.length; i++) {
        // Loop the numbers one more time, comparing each of them 
        // all the other numbers in the array
        for (int j = 0; j < numbers.length; j++) {

            // Do not compare the same number to itself, as these 
            // will always be equal (and is not really what we want to do)
            if (i == j) {
                continue;
            }

            // If the two numbers are equal, continue to the next number, 
            // this one is not a single occurence
            if (numbers[i] == numbers[j]) {
                break;
            }

            // If the value (index) of j equals the length of the array, 
            // and we did not break on the previous if, we know
            // that the current (outer) number is a single occurence, 
            // increase the count
            if (j == (numbers.length - 1)) {
                count++;
            }
        }
    }

    // Return the number of single occurences
    return count;
}