while(!found)
{
    mid = (begin + end)/2;

    if(array[mid] == search)
    {
        found = true;
    }
    else if(array[mid] < search)
    {
        begin = mid+1;
    }
    else if(array[mid] > search)
    {
        end = mid-1;
    }

}//end of while loop