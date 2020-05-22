for(int i = 0; i < table.size(); i++)
{
    if(i == column)
    {
        table.get(i).add(value);
    }
    else
    {
        table.get(i).add("");
    }
}