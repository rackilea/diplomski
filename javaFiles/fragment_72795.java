public static void printRow(int row[], int numRows, int shift, PrintWriter writer) { 

    String formatString = "";
    for (int i = 0; i < row.length; i++) { // firstly, should be i = 0 and row.length is used here ...
        formatString += row[i] + " ";
    }
    // start a new line:
    System.out.println();

    // print out all the space chars for the shift:
    for (int j = 0; j < shift; j++) {
        System.out.print(" ");
    }

    System.out.print(formatString);
    writer.printf(formatString);
}