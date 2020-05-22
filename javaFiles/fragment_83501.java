for(int i = 0; i < count; i++)
{
    if (number == myArray[i])
    {
        containsNumber = true;
    }
}

if ( !containsNumber )
{
   myArray [ count ] = number;
   count++;
} // end if