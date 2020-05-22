public static void main(String[] args) {

    char[] a = {'.', '.', '*', '.', '*'};
    char[] b = {'.', '*', '*', '.', '*'};
    char[] c = {'.', '.', '*', '.', '*'};
    char[] d = {'.', '*', '*', '.', '*'};
    char[] e = {'*', '.', '*', '.', '*'};
    char[][] ae = {a, b, c, d, e};

    char[][] numberArray = new char[5][5];


    for (int i = 0; i < ae.length; i++) {
        for (int j = 0; j < ae[i].length;  j++) {
            numberArray[i][j] = checkAdjacentField(i, j, ae);
        }
    }
    StringBuilder matrix = new StringBuilder();

    for (char[] aNumberArray : numberArray) {
        StringBuilder bld = new StringBuilder("{");
        for (char character : aNumberArray) {
            bld.append(character).append(",");
        }
        bld.deleteCharAt(bld.length() - 1);
        bld.append("}");
        matrix.append(bld.toString()).append("\n");
    }
    System.out.println(matrix.toString());
}

private static char checkAdjacentField(int i, int j, char[][] ae) {
    int count = 0;
    if (j <= ae[i].length - 2) { // to the right
        count += ae[i][j + 1] == '*' ? 1 : 0;
    }
    if (j <= ae[i].length - 2 && i <= ae.length -2) { // move to top right
        count += ae[i + 1][j + 1] == '*' ? 1 : 0;
    }
    if (j <= ae[i].length - 2 && i > 0) { // move to bottom right
        count += ae[i - 1][j + 1] == '*' ? 1 : 0;
    }
    if (j > 0) { // to the left
        count += ae[i][j - 1] == '*' ? 1 : 0;
    }
    if (j > 0 && i <= ae.length -2) { // to top left
        count += ae[i + 1][j - 1] == '*' ? 1 : 0;
    }
    if (j > 0 && i > 0) { // to bottom left
        count += ae[i - 1][j - 1] == '*' ? 1 : 0;
    }
    if (i <= ae.length -2) { // move to top
        count += ae[i +1][j] == '*' ? 1 : 0;
    }
    if (i > 0) { // move top bottom
        count += ae[i - 1][j] == '*' ? 1 : 0;
    }
    System.out.printf("field %s, %s has %s Adjacent fields with a * \n", i, j , count);
    String stringValue = String.valueOf(count);
    return stringValue.charAt(0);
}