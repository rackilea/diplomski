ArrayList<String> oneList = new ArrayList<String>();

oneList.add("7");
oneList.add("525");
oneList.add("85");
oneList.add("365");
oneList.add("78");
oneList.add("1");

int[] arrayOfValues = new int[oneList.size()];  
int i = 0;
for(String value: oneList)
{   
    try
    {
        arrayOfValues[i] = Integer.parseInt(value);
        i++;
    }
    catch(Exception e)
    {
        System.out.println("Not an integer value");
    }
}