while(input.hasNextLine())
{
    String result = "";
    for(int i = 0; i < IDs.size(); i++)
    {
        result += (IDs.get(i) + " ");
    }
    output.println(result);
}