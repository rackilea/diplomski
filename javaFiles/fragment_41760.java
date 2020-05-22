static String[] initStrings = { "...../...\", "..\.......", "......./..", "..........", "........\.", "..........", "..........", ".....\../.", "..\....../", ".........." };
char[][] squares = new char[10][10];
int row, col;

for (row = 0; row < 10; rows ++)
{
    for (col = 0; col < 10; col++)
    {
        squares[row][col] = initStrings[row].charAt(col);
    }
}

// print squares
for (row = 0; row < 10; rows ++)
{
    for (col = 0; col < 10; col++)
    {
        System.out.print(squares[row][col] + " ");
    }

    System.out.print("\n");
}