try
{
    input = new Scanner(new File("ItemRecord_text.txt"));
    while (input.hasNext())
    // ...
}
catch (IOException e)
{
    e.printStackTrace();
}//end catch