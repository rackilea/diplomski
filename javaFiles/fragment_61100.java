public static char myGetOpposingPit(char b, int[][] ints) {
    char retChar = 'z';
    int retVal = 0;
    int charPosi = 0;
    int total97 = 0;

    charPosi = (int)b;
    total97 = charPosi - 97;

    for (int i = 0; i < 2; i++) {

        for (int j = 0; j < ints[0].length; j++) {

            if (total97 < ints[0].length) {
                if (total97 == j) {
                    retVal = (charPosi + ints[0].length);
                    retChar = (char)retVal;
                }
            } else if (total97 >= ints[0].length) {
                if (total97 == (j + (ints[0].length))) {
                    retVal = (charPosi - ints[0].length);
                    retChar = (char)retVal;
                }
            }
        }
    }

    return retChar;
}