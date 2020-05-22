int columns = 10;
int rows = 10;

int[][] grid = new int[rows][columns];



for (int i = 0; i < grid.length; i++)
{
    for (int j = 0; j < grid.length; j++)
    {
        grid[i][j] = 0;
        System.out.print(grid[i][j] + " ");
    }
    System.out.println();
}