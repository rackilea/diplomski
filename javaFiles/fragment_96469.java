int rows=4;
int cols=4;
int [][] gameboard = new int[rows][cols];
int cellSize = 4;
int rowLength = cols * cellSize + cols + 1;
final char[] array = new char[rowLength];
Arrays.fill(array, '-');
String rowDivider = new String(array);
for(int i = 0; i < gameboard.length; i++)
{
    System.out.println(rowDivider);
    for(int j = 0; j < gameboard[i].length; j++)
    {
        System.out.printf("|%"+cellSize+"d",gameboard[i][j]);
        if(j == (gameboard[i].length - 1)) System.out.println("|");
    }
}
System.out.println(rowDivider);