try
{
    input = new Scanner(new File("ItemRecord_text.txt"));
}
catch (IOException e)
{
    e.printStackTrace();
}//end catch
while (input.hasNext())
// ...