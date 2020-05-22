public static void main(String[] args) {
    System.out.println(luckySum(1, 2, 3));
    System.out.println(luckySum(1, 2, 13));
    System.out.println(luckySum(1, 13, 3));
}
/**
 * Given 3 int values, a b c, return their sum. However, if one of the values is 13 
 * then it does not count towards the sum and values to its right do not count. 
 * So for example, if b is 13, then both b and c do not count.
 * 
 * e.g.:
 * luckySum(1, 2, 3) -> 6
 * luckySum(1, 2, 13) -> 3
 * luckySum(1, 13, 3) -> 1
 * 
 */
public static int luckySum(int... values) {
    // Using varargs for dynamic amound of values
    // Sum variable
    int sum = 0;
    // loop over all values
    for(int x=0; x<values.length; x++) {
        // in the case 13 is found break out of the loop
        if(values[x] == 13) {
            break;
            // As a second option you could just return sum here
            // return sum;
        }
        // add value to the sum
        sum += values[x];
    }
    return sum;
}