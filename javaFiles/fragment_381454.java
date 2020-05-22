static Map<String, String> map1 = new HashMap<>();

static {
    map1.put("param1","param11");
    map1.put("param2","param22");
}

static Object[][] array1 = new Object[][]{
            {"1", 1},
            {"2", 2}
};

public static void main (String[] args) throws java.lang.Exception
{
    // the new array has precisely N*M rows
    // where N is the number of rows in the input array
    // and M is the number of entries in the map
    Object[][] newArray = new Object[array1.length * map1.size()][4];
    int index = 0;
    for(int row=0;row<array1.length;row++)
    {
        for(Map.Entry<String, String> en : map1.entrySet())
        {
            Object[] newRow = new Object[4];
            newRow[0] = array1[row][0];
            newRow[1] = array1[row][1];
            newRow[2] = en.getKey();
            newRow[3] = en.getValue();
            newArray[index] = newRow;
            index++;
        }
    }
}