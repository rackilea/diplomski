public static int sumTripletsGivenLength(int length){
    int sum = 0;

    // the two for loops below are structured such that duplicate pairs
    // of values, e.g. (3, 4) and (4, 3), do not occur
    for (int a=1; a < length; ++a) {
        for (int b=a; b < length; ++b) {
            // calculate hypotenuse 'c' for each combintation of 'a' and 'b'
            double c = Math.sqrt(Math.pow(a, 2.0) + Math.pow(b, 2.0));

            // check if 1) 'c' be a whole number, and 2) its length is within range
            if (c == Math.ceil(c) && c < length) {
                sum = a + b + (int)c;
                System.out.println(a + "-" + b + "-" + (int)c);
            }
        }
    }

    return sum;
}

public static void main(String args[]) {
    int inputLength = 15;

    System.out.println("Given the length: " + inputLength + 
        " the sum of the pythagorean triplets in the given range is: " 
        + sumTripletsGivenLength(inputLength));
}