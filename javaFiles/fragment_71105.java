try(
    Scanner input = new Scanner(source);
    PrintWriter output = new PrintWriter(temp);
){
    while(...)
    {
       ...
    }
}
// Try block finished, resources now auto-closed
if (!source.delete())
{
    throw new RuntimeException("Couldn't delete file!");
}
if (!temp.renameTo(source))
{
    throw new RuntimeException("Couldn't rename file!");
}