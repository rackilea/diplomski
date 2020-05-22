public class HelloWorld
{
  public static void main(String[] args)
  {
    int[][] init = new int[][]{
            {0, 0, 5, 0, 2, 1, 7, 0, 0},
            {0, 9, 0, 0, 7, 0, 0, 6, 0},
            {8, 0, 0, 3, 5, 0, 0, 0, 4},
            {7, 0, 0, 1, 8, 0, 3, 0, 0},
            {0, 2, 0, 0, 9, 0, 0, 1, 0},
            {0, 0, 1, 2, 6, 0, 0, 0, 7},
            {6, 0, 0, 0, 0, 2, 0, 0, 9},
            {0, 3, 0, 0, 4, 0, 0, 7, 0},
            {0, 0, 4, 5, 0, 0, 8, 0, 0},
    };
    SudokuMatrix s = new SudokuMatrix(init);

    s.printMatrix();
  }
}

public class SudokuMatrix
{
  private final int sudoku[][];



  public SudokuMatrix(int[][] sudoku){
    this.sudoku= new int[9][9]; //note here I allocated a 9x9 matrix rather than copying each row in the matrix

    if (sudoku.length != 9 || sudoku[0].length != 9) 
    {
        throw new IllegalArgumentException("Wrong dimension!");
    }
    else
    {
        for (int i = 0; i < 9; i++) 
        {
            for(int j = 0; j < 9; j++){
               this.sudoku[i][j] = sudoku[i][j];
            }

        }

    }
}

  public void printMatrix(){
    for(int i = 0; i < 9; i++){

      String inner = "";
      for(int j = 0; j < 9; j++){
        if(sudoku[i][j] == 0){
              inner += ".";
        }
        else{inner += sudoku[i][j];}
    }
      System.out.println(inner);
  }
}
}