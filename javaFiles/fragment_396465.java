public void addToColumns(Map<int, String> data, List<List<String>> table)
{
    for(int key : data.keyset())
    {
        table.get(key).add(data.get(key));
    }

    for(int i = 0; i < table.size(); i++)
    {
        if(!data.containsKey(i))
        {
            table.get(i).add("");
        }
    }
}