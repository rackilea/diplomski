public class ArrayOps {

    static private final int    SIZE    = 10;

    public static void main(final String[] args) {
        System.out.println("Welcome to the Tennessee Lottery");
        System.out.println("----------------------------");
        final int[] k = new int[SIZE];
        final int[] n = new int[SIZE];
        enterNumbers(k, n);
        if (containSameElements(k, n) == true) //PROBLEM AREA
            System.out.println("Winner!");
        else System.out.println("Loser.");
    }

    private static void enterNumbers(final int[] pK, final int[] pN) {
        for (int i = 0; i < SIZE; i++) {
            pK[i] = (int) (Math.random() * SIZE);
            pN[i] = (int) (Math.random() * SIZE);
        }
    }

    public static boolean containSameElements(final int[] pK, final int[] pN) {
        if (pK.length != pN.length) return false;

        // mandatory check
        for (final int k : pK) {
            if (!arrayContains(pN, k)) return false;
        }

        // optional check, only if arrays have to contain EXACTLY the same elements
        for (final int n : pN) {
            if (!arrayContains(pK, n)) return false;
        }

        return true;
    }

    static private boolean arrayContains(final int[] pArray, final int pLookForNumber) {
        for (final int i : pArray) {
            if (i == pLookForNumber) return true;
        }
        return false;
    }

    public static int[] drawNumbers(final int k, final int n) {
        final int drawNumbers[] = new int[k];
        int randNumber;
        int i = k;
        for (i = 0; i < drawNumbers.length; i++) {
            randNumber = (int) (Math.random() * n + 1); // random draw number
            drawNumbers[i] = randNumber;
        }
        System.out.println();
        System.out.println("Your drawn numbers are: ");
        for (i = 0; i < drawNumbers.length; i++) //counter i
        {
            System.out.print(drawNumbers[i] + " ");
        }
        return drawNumbers;
    }

}