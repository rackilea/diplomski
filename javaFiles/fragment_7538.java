public static void printTriagle(int n) {
    for (int i = 0; i < n; i++) {

        for (int j = n - i; j > 1; j--) {
            System.out.print("_");
        }
        String s = "_";
        if (i + 1 >= n) // check if it is the last line
            s = "*"; // change to print * instead of _

        for (int j = 0; j <= i; j++) {
            // printing stars
            if (j == i)
                System.out.print("*#"); // check if the last print of the line
            else if (j == 0)
                System.out.print("*" + s); // check if the first print of the line
            else
                System.out.print(s + s);
        }

        System.out.println();
    }
}