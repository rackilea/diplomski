public static <T> int linearSearch(final T[] data, final T value)
{
    int index;

    index = -1;

    if(data != null)
    {
        for(int i = 0; i < data.length; i++)
        {
            if(value == null)
            {
                if(data[i] == null)
                {
                    index = i;
                    break;
                }
            } 
            else
            {            
                if(value.equals(data[i]))
                {
                    index = i;
                    break; // stop looking
                }
            }
        }    
    }

    return (index);
}