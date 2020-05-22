// Count the array that have name with same length
static int countByLength(String [] names, int length)
{
    int count = 0;

    for(int i = 0;i < names.length;i++)
    {
      if(names[i].length() = length) count++;
    }


    return count;
}


/**
 * Filter an array of names and keep only those names with a given length
 * @param names: an array of names
 * @param length: an integer length
 * @return the array of names that have the given length
 */
static String [] filterByLength(String [] names, int length)
{
    String [] filtered = new String[countByLength(names, length)];
    int index = 0;

    for(int k = 0; k < filtered.length; k++)
    {
        if(names[k].length() == length) filtered[index++]=names[k];
    }

    return filtered; 
}