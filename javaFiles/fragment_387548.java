public char[][] readFile(String filename)
{
    char[][] maze;
    try
    {
        ...
        maze=<a useful value>
    }
    catch (FileNotFoundException e)
    {
        e.printStackTrace();
        maze=<a default value, maybe null>
    }
    return maze;
}