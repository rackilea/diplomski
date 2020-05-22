public static int getDigit(char character, char letters[][]) {
    int digit = -1; // return -1 if character not found

    for (int i=0;i < letters.length; i++) {
        for (int j=0; j < letters[i].length; j++) {
            if (letters[i][j] == character) {
                digit = i;
                i = letters.length;
                break;
            }
        }    
    }

    return digit;
}

public static void main(String args[]) {
    char[][] letters = new char[][] {
        { 'a', 'b', 'c' },
        { 'd', 'e', 'f' },
        { 'g', 'h', 'i' },
        { 'j', 'k', 'l' },
        { 'm', 'n', 'o' },
        { 'p', 'q', 'r', 's' },
        { 't', 'u', 'v' },
        { 'w', 'x', 'y', 'z' }};
    System.out.println(getDigit('d', letters) );
}