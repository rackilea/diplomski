public String[] getData(String name)
{
    String[] data = new String[2];
    boolean wineFound = false;

    for (int i = 0; i < d.length; i++)
    {
        if( d[i].name.equals(name) )
        {
        data[0] = name;
        data[1] = d[i].price;
        wineFound = true;
        }
    }

    if (wineFound == true)
        return data;
    else
    {
    data[0] = "error";
    data[1] = "error";
    return data;
    }
}