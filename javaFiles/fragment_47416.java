/**
 * Cage constraint Check: Checks if num is an acceptable value for the
 * given Cage
 *
 * Precondition: Given cell is empty, and has passed rowConstraintCheck() and
 * columnConstraintCheck()
 */
public static boolean cageConstraintCheck(
        int rowIndex, int columnIndex, int num) {

    int cageIndex =  cellToCageMapper[rowIndex][columnIndex];          
    Cage cage = cages.get(cageIndex); // or whatever class-name you are using

    String currentOperator = cage.cageOperator;
    int targetValue = cage.cageValue;

    // Sum and product of all cells in cage, including the new one.
    int sum = num;
    int product = num;

    // Last non-zero value seen in the cage, not counting the new one.
    int last = -1;

    int numberOfEmptyCellsInCage = 0;
    int numberOfCellsInCage = cage.placeHolders.length;            

    if (numberOfCellsInCage == 1)
    {
        // Single-cell cage
        return (targetValue == num);
    }

    for (int j = 0; j < numberOfCellsInCage; j++) {
        int cellIndex = cage.placeHolders[j];
        int cellRow = (cellIndex / puzzleDimension); // Integer division
        int cellCol = (cellIndex % puzzleDimension);
        int cellValue = puzzleArray[cellRow][cellCol];
        if (cellValue == 0) {
            // Empty cell
            numberOfEmptyCellsInCage++;
        }
        else {
            // Update the tracking variables
            sum += cellValue;
            product *= cellValue;
            last = cellValue;
        }
    }

    if (numberOfEmptyCellsInCage == 1 && last != -1) {
        // The new number will be placed in the only empty spot in the cage.

        // For subtraction and division, there will only be two cells. Sort
        // their values onto 'low' and 'high'.
        int low = num < last ? num : last;
        int high = num + last - low;

        switch (currentOperator.charAt(0)) {
            case '+':
                if (targetValue != sum) {
                    // The new value would produce an incorrect sum
                    return false;
                }
                break;
            case '*':
                if (targetValue != product) {
                    // The new value would produce an incorrect product
                    reutrn false;
                }
                break;
            case '-':
                if (targetValue != high - low) {
                    // The new value would produce an incorrect difference
                    return false;
                }
                break;
            case '/':
                if (high % low != 0 || targetValue != high / low) {
                    // The new value would produce an incorrect quotient
                    return false;
                }
                break;
        }
    }

    return true;
}