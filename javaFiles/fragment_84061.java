public static void init() {
    // define constants
    final int length = 3;
    final char maxValue = '3';

    // define buffer
    final char[] array = new char[length]; java.util.Arrays.fill(array, '0');
    final boolean[] alreadySet = new boolean[length]; java.util.Arrays.fill(alreadySet, false);

    // fill first digit, then let the recursion take place
    for(char c = '1'; c <= (char)(maxValue); c++) {
        // iterate from lowest to highest digit
        for(int i = array.length-1; i >= 0; i--) {
            // set value
            array[i] = c;
            alreadySet[i] = true;
            // print value
            System.out.println(new String(array));
            // call recursion
            recursive(array, c, i, alreadySet, length);
            // unset value
            alreadySet[i] = false;
            array[i] = '0';
        }
    }
}

public static void recursive(char[] array, char lastValue, int lastIndex, boolean[] alreadySet, int leftToSet) {
    // if we didn't set all digits
    if(leftToSet > 0) {
        // iterate from lowest to highest digit
        for(int i = array.length-1; i >= 0; i--) {
            // missing all digits already set
            if(!alreadySet[i]) {
                // count from 1 to lastValue-1
                for(char c = '1'; c < lastValue; c++) {
                    // set value
                    array[i] = c;
                    alreadySet[i] = true;
                    // print value
                    System.out.println(new String(array));
                    // call recursion
                    recursive(array, c, i, alreadySet, leftToSet-1);
                    // unset value
                    alreadySet[i] = false;
                    array[i] = '0';
                }
            }
        }

        char c = lastValue;
        // iterate from lowest to highest digit
        for(int i = array.length-1; i > lastIndex; i--) {
            // missing all digits already set
            if(!alreadySet[i]) {
                // set value
                array[i] = c;
                alreadySet[i] = true;
                // print value
                System.out.println(new String(array));
                // call recursion
                recursive(array, c, i, alreadySet, leftToSet-1);
                // unset value
                alreadySet[i] = false;
                array[i] = '0';
            }
        }
    }
}