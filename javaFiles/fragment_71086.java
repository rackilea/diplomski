public int[] above100Degrees()
{
    int newArrayLength=0;
    for( int i = 0; i < temps.length; i++ )
    {
        if( temps[i] > 100 )
        {
            newArrayLength++;
        }
    }

    int[] blazing = new int[newArrayLength];
    int positionInNewArray = 0;
    for( int i = 0; i < temps.length; i++ )
    {
        if( temps[i] > 100 )
        {
            blazing[positionInNewArray] = temps[i];
            positionInNewArray++;
        }
    }
    return blazing;
}