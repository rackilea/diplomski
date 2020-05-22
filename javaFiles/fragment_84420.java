public class BruteForceTest {

    public static boolean bruteforce(int[] input) {

        // NOTE: Cover the edge cases that the input array is null or has one element.
        if (input == null || input.length == 1)
            return true; // NOTE: Returning true for null is debatable, but I leave that to you.

        int compare = input[0]; // NOTE: Compare to the first element of the input array.

        // NOTE: Check from the second element through the end of the input array.
        for (int i = 1; i < input.length; i++) {
            if (input[i] != compare)
                return false;
        }

        return true;

    }

    public static void main(String[] args) {

        int[] denominator = {3,3,4,3};
        boolean compare = bruteforce(denominator);

        // FORNOW: console output to see where the first check landed
        System.out.print("{3,3,4,3}:\t");
        if (compare)
            System.out.println("Yup!");
        else
            System.out.println("Nope!");

        // NOTE: a second array to check - that we expect to return true
        int[] denominator2 = {2,2};
        boolean compare2 = bruteforce(denominator2);

        System.out.print("{2,2}:\t\t");
        if (compare2)
            System.out.println("Yup!");
        else
            System.out.println("Nope!");

        /*
         *  NOTE: edge cases to account for as noted below
         */

        // array with one element
        int[] denominator3 = {2};
        System.out.print("{2}:\t\t");
        if (bruteforce(denominator3))
            System.out.println("Yup!");
        else
            System.out.println("Nope!");

        // null array
        System.out.print("null:\t\t");
        if (bruteforce(null))
            System.out.println("Yup!");
        else
            System.out.println("Nope!");

    }

}