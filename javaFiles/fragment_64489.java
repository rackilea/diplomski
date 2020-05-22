private static void displaySeating(int s,int n) {

int  i, k;

    i = 0;
    k = 0;

    // print left edge
    System.out.print("#");

    while (i < s) {
        i++;
        System.out.print("\t X");
        if (i % 8 == 0) {
            // print right edge
            System.out.println("\t#");

            // print left edge of next row
            System.out.print("#");
        }
    }        

    while ( k < n) {
        k++;
        System.out.print("\t O");
        if ((k+s) % 8 == 0)  {
            // print right edge
            System.out.println("\t#");

            // print left edge of next row
            System.out.print("#");
        }
    }

    if ((s + n) % 8 != 0) {
        // this means the last row isn't completely full with 0's

        // fill up the row with tabs to get to the edge
        while ((k+s) % 8 != 0) {
            k++;
            System.out.print("\t");
        }
        // print the right edge
        System.out.println("\t#");

        // add the lower edge
        System.out.println("#########################################################################"); 
    } else {
        // this means the last row was filled completely but the left edge of 
        // the next row has already been printed, so we make the lower edge 1 smaller.
        System.out.println("########################################################################");
    }
}