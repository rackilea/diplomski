ArrayList wholeList = new ArrayList<Integer>();
for(int x = 0; x < fline; x++)
    {
        parts = wholef[x].split(" ");
        for(int n = 0; n < parts.length; n++)
        {
            wholeList.add(Integer.parseInt(parts[n]));
        }
    }