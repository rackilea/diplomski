public class Project1 {
    public static void main(String [] args) {
        //ScrabbleLetterBag letterBag = new ScrabbleLetterBag();
        char [][] scrabbleBoard = new char [16][16];

        for (int i = 0; i<scrabbleBoard.length; i++) {
            if (i != 0) {
                System.out.println("\t");
                System.out.print(i-1);
            }

            for (int j = 1; j <scrabbleBoard.length; j++) {
                if (j == 8 && i == 8) {
                    scrabbleBoard[i][j] = '*';
                    System.out.print(scrabbleBoard[i][j]);  
                }
                else {
                    if (i == 0) {
                        System.out.print("\t");
                        System.out.print(j-1);
                    }
                    else {
                        scrabbleBoard[i][j] = '_';
                        System.out.print("\t");
                        System.out.print(""+scrabbleBoard[i][j]);
                    }
                }
            }
        }
    }
}