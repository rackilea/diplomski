//This for loop will print out the cell array to the screen.//
for (int i = 0; i < numRows; i++)
{
    for (int j = 0; j < numColumns; j++)
    {
        location[i][j].printCell();  // location[i][j] not instantiated
    }
    System.out.print("\n");
}