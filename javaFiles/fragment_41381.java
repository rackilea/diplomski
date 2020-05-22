public class LetterE
{
    public static void main(String args[])
    {


        final int NUM_ACROSS = 3;   // Number of asterisks to print across.
        final int NUM_DOWN = 5;     // Number of asterisks to print down.

        int row;    // Loop control for row number.
        int column; // Loop control for column number.

        // This is the work done in the detailLoop() method
        // Write a loop to control the number of rows.
        for(row = 1; row <= NUM_DOWN; row++) {
            if(row == 1 || row == 3 || row == 5 || row == NUM_DOWN)
                for(column = 1; column <= NUM_ACROSS; ++column) {
                    if (column == 2 || column == 4 || column == NUM_ACROSS)
                        // Write a loop to control the number of columns
                        // Decide when to print an asterisk in every column.
                        System.out.print("*");
                  } // <<< here it is, you misplaced one curly bracket (delete extra one before System.exit and you're good to go)
                    // Decide when to print asterisk in column 1.
                    System.out.print("*");
                    // Decide when to print a space instead of an asterisk.
                    System.out.print(" ");
                    // Figure out where to place this statement that prints a newline.
                    System.out.println();
                }
        // This is the work done in the endOfJob() method
        System.exit(0);
    } // End of main() method.

} // End of LetterE class.