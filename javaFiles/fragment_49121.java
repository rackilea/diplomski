import java.util.Scanner;

public class APComSci9p1 {// Start program

    public static void main(String[] args) {// Start Main

        // Initilize inputs
        Scanner scnKey = new Scanner(System.in);

        // Initialize Arrays
        int[] aOriginValues, aEvenList, aOddList, aNegitiveList;

        aOriginValues = new int[10];
        aEvenList = new int[10];
        aOddList = new int[10];
        aNegitiveList = new int[10];

        // Initialize Array index Variables
        int iInput;
        int iListControlE = 0;
        int iListControlO = 0;
        int iListControlN = 0;

        // Start Loop
        for (iInput = 0; iInput <= 9; iInput++) {
            System.out.print("Input value: ");
            aOriginValues[iInput] = scnKey.nextInt();

            // Start if/else
            if ((aOriginValues[iInput] % 2) == 0) {
                aEvenList[iListControlE++] = aOriginValues[iInput];
            } else {
                aOddList[iListControlO++] = aOriginValues[iInput];
            } // end if/Else
            if (aOriginValues[iInput] < 0) {
                aNegitiveList[iListControlN++] = aOriginValues[iInput];
            } // end if
        } // End loop

        // Initialize Loop Specific variables
        int iLimit;

        // Start if/else #2
        if ((iListControlE >= iListControlO)
                && (iListControlE >= iListControlN)) {
            iLimit = iListControlE;
        } else if ((iListControlO >= iListControlE)
                && (iListControlO >= iListControlN)) {
            iLimit = iListControlO;
        } else {
            iLimit = iListControlN;
        } // End if/else #2

        System.out.println("    Even        Odd       Negitive  ");
        for (int iControl = 0; iControl <= iLimit; iControl++) {
            System.out.printf("%,12d%,11d%,12d%n", aEvenList[iControl],
                    aOddList[iControl], aNegitiveList[iControl]);
        }

    }// End Main
}// End program