//test data 
private static int[][] bin = {
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,0,0,0,1,1,1},
            {1,1,1,1,0,0,0,1,1,1},
            {1,1,1,1,0,0,0,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
          };

public static void main(String[] args) {

        System.out.println(isEnoughtSpace(1, 1));// output - true
        System.out.println(isEnoughtSpace(2, 2));// output - true
        System.out.println(isEnoughtSpace(3, 3));// output - true
        System.out.println(isEnoughtSpace(1, 3));// output - true
        System.out.println(isEnoughtSpace(3, 1));// output - true
        System.out.println(isEnoughtSpace(4, 1));// output - false
        System.out.println(isEnoughtSpace(4, 5));// output - false
        System.out.println(isEnoughtSpace(11,11));// output - false
        System.out.println(isEnoughtSpace(0,0));// output - true
    }

    private static boolean isEnoughtSpace(int rectHeight, int recWidth) {

        for(int row = 0; row <= (bin.length - rectHeight); row++) {

            for(int col = 0; col <= (bin[0].length - recWidth); col++) {

                if(isEnoughtSpace(row, col, rectHeight, recWidth)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isEnoughtSpace(int rowIndex, int colIndex,int rectHeight, int recWidth) {

        for(int row = rowIndex; row < (rowIndex+rectHeight) ; row ++) {

            for(int col = colIndex; col < (colIndex+recWidth) ; col++) {
                if(bin[row][col] == 1 ) {
                    return false;
                }
            }
        }
        return true;
    }