class MyContainer
{
    private Map<int, Map<int, List<string>>> data; //initialize in constructor

    public void setDataAt(int x, int y, List<string> value)
    {
        if (!data.ContainsKey(x))
        {
            data[x] = new HashMap<Map<int, Map<int, string>>();
        }
        if (!data[x].ContainsKey(y))
        {
            data[x] = new HashMap<int, string>();
        }
        data[x][y] = value;
    }
}