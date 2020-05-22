public static boolean hasDuplicates(int[][] num)
{
    boolean hasDuplicate  = false;
    // for each line in num
    for(int[] line : num)
    {
        // for every number in the row
        for(int i = 0; i < line.length && !hasDuplicate; i++)
        {
            // for every number in the row
            for(int j = 0; j < line.length; j++)
            {
                // if we are not comparing the same number
                if(i != j)
                {
                    // check for equality
                    if(line[i] == line[j])
                    {
                        hasDuplicate = true; // we have found a duplicate
                        break; // no need to keep checking; break the loop and return
                    }
                }
            }
        }
    }
    return hasDuplicate;
}