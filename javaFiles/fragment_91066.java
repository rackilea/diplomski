public class Mod4Lec { //class names are started from Uppercase letter
    public static void main(String[] args) {

        // Creates array of boolean
        boolean[][] array = { { true, false, true, false }, { false, true, false, true }, { true, false, true, false },
                { false, true, false, true }, };

        System.out.println("Before: ");
        // Prints original array

        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++)
                System.out.print(array[row][column] + "  ");
            System.out.println();
        }

        boolean[][] newArray = swapArray(array); 
        System.out.println("After: ");
        for (int row = 0; row < newArray.length; row++) {
            for (int column = 0; column < newArray[row].length; column++)
                System.out.print(newArray[row][column] + "  ");
            System.out.println();
        }

    }

    // Pass array to method
    public static boolean[][] swapArray(boolean[][] array) { //return 2d array, not void
        // Copy array
        // you should have 2d array here, my guess is that every array "row" is of the same size
        boolean[][] newArray = new boolean[array.length][array[0].length];  
        // again, we have 2d array and need to go for each rows to each columns
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++)
                newArray[row][column] = array[row][column];
        }
        // Search for boolean true and switch to false
        // the same 2d
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[i].length; j++) //2nd dimension
                newArray[i][j] = !newArray[i][j]; // just invert 
        }
        return newArray;
    }
}