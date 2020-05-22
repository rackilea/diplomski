public boolean main(int []array1, int []array2) 
{
    for(int i=0;i<10;i++)
    {
        for(int j=0;j<10;j++)
        {
                if(array1[i]==array2[j]) 
                {
                    break;
                }
                else if (array1[i] != array2[j])
                    return false;
        }
    return true;
    }
}