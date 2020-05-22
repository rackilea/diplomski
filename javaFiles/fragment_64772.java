public class Paths {
public static int countPaths(int[][] a) {
    //declare method variables
    int start = a[0][0], tens = start / 10, ones = start % 10;
    boolean downByTens, downByOnes;

    //set the case booleans
    if(tens <= a.length-1 && ones <= a[tens].length-1) {
        downByTens = true;
    } else {
        downByTens = false;
    }

    if(ones <= a.length-1 && tens <= a[ones].length-1) {
        downByOnes = true;
    } else {
        downByOnes = false;
    }

    //check the cases, return the overloaded method
    if(downByTens) {
        if(downByOnes) {
            return countPaths(a, tens, ones) + countPaths(a, ones, tens);
        } else {
            return countPaths(a, tens, ones);
        }
    } else {
        if(downByOnes) {
            return countPaths(a, ones, tens);
        } else {
            return 0;
        }
    }
}

private static int countPaths(int[][] a, int row, int col) {
    //declare method variables
    int current = a[row][col], tens = current / 10, ones = current % 10, end = a[a.length-1][a[0].length-1];
    boolean downByTens, downByOnes;

    //set the case booleans
    if(row + tens <= a.length-1 && col + ones <= a[row + tens].length-1) {
        downByTens = true;
    } else {
        downByTens = false;
    }

    if(row + ones <= a.length-1 && col + tens <= a[row + ones].length-1) {
        downByOnes = true;
    } else {
        downByOnes = false;
    }

    //check to see if the end of the array has been reached
    if(current == end) {
        return 1;
    } else {
        //check the cases
        if(downByTens) {
            if(downByOnes) {
                return countPaths(a, row + tens, col + ones) + countPaths(a, row + ones, col + tens);
            } else {
                return countPaths(a, row + tens, col + ones);
            }
        } else {
            if(downByOnes) {
                return countPaths(a, row + ones, col + tens);
            } else {
                return 0;
            }
        }
    }
}
}