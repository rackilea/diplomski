static int[][] sudoku = new int[9][9];

public static boolean CheckRow(int a, int b, int[][] sudoku, int rnum)
{
    boolean check = true;
    for(int c = b; c > 0; c--)
    {
        if(sudoku[a][c - 1] == rnum)
        {
            return false;
        }
    }

    return check;
}

public static boolean CheckCol(int a, int b, int[][] sudoku, int rnum)
{
    boolean check1 = true;
    for(int c = a; c > 0; c--)
    {
        if(sudoku[c - 1][b] == rnum)
        {
            return false;
        }
    }

    return check1;
}

public static boolean fill(int a, int b) {
    Random rand = new Random();
    int rnum = rand.nextInt(9) + 1;
    boolean checkWhile = false;
    for(int i = 0; i < 9 && !checkWhile; i++) {
        if(CheckRow(a, b, sudoku, rnum) && CheckCol(a, b, sudoku, rnum))
        {
            sudoku[a][b] = rnum;
            if(a == 8 && b == 8) return true;
            if(b == 8) checkWhile = fill(a+1,0);
            else checkWhile = fill(a,b+1);
        }
        if(rnum == 9) rnum = 1;
        else rnum += 1;

    }
    return checkWhile;
}

public static void main(String[] args) {    
    fill(0,0);
    for(int i = 0; i < 9; i++) {
        for(int j = 0; j < 9; j++) {
            System.out.print(sudoku[i][j]+" ");
        }
        System.out.println("");
    }

}