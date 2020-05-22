if (grid[row][col] == true)
{
    if (neighbors == 2 || neighbors == 3 )
    {
        grid2[row][col] = true;
    }
    else 
    {
        grid2[row][col] = false;
    }

if (grid[row][col] == false)
{
    if (neighbors > 2)
    {
        grid2[row][col] = false;
    }
    if (neighbors == 3)
    {
        grid2[row][col] = true;
    }   
}