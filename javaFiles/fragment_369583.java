public class StringCharPlaceChanger {

    public static void main(String[] args) {

        String input = "AAA BB";
        System.out.println("Input: " + input);
        System.out.println();

        String result = stringCharPlaceChanger(input);

        System.out.println();
        System.out.println("Output: " + result);

    }

    public static String stringCharPlaceChanger(String stringToChange) {

        // input can not be null
        if (stringToChange == null) {
            System.out.println("Error: string can not be null");
            return null;
        }

        // index of space
        int x = stringToChange.indexOf(" ");

        // a space is required
        if (x == -1) {
            System.out.println("Error: no space found");
            return null;
        }

        // input converted in array
        char[] c = stringToChange.toCharArray();

        // number of chars on the left
        int numberOfLeft = x;

        // number of chars on the right
        int numberOfRight = c.length - x - 1;

        // length of the input
        int l = c.length;

        boolean first = true;

        // print of the original input
        System.out.println(stringToChange);

        while (numberOfRight > 0) {

            // after the first cycle
            if (!first) {
                // reset the position of the space near the next number to move 
                x = goTo(c, x, l - numberOfRight - 1);
            }
            else {
                first = false;
            }

            // move a char from right to left
            // basic algorithm:
            // a_b
            // ab_
            // _ba
            // b_a

            // a_b -> ab_
            x = swap(c, x, x + 1);
            for (int left = numberOfLeft; left > 0; left--) {
                // ab_ -> _ba
                x = swap(c, x, x - 2);
                // _ba -> b_a
                x = swap(c, x, x + 1);
            }

            numberOfRight--;

        }

        return new String(c);
    }

    // swap 2 chars
    private static int swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        System.out.println(c);
        return j;
    }

    // go from left to right swapping chars
    private static int goTo(char[] c, int i, int j) {
        while (i < j) {
            if (i == j - 1) {
                i = swap(c, i, i + 1);
            }
            else {
                i = swap(c, i, i + 2);
            }
        }
        return j;
    }

}