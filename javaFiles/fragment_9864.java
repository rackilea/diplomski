for(index = 1; index < ds.length; index++) // OK: loop control variable is incremented here
    {
        if(ds[index - 1] <= ds[index] )
        {
            ++index; // No-no: incrementing loop control variable, dangerous
        }
        else
        {
            tmp1 = ds[index];
            tmp2 = sq[index];
            ds[index] = ds[index - 1];
            sq[index] = sq[index - 1];
            ds[index-1] = tmp1;
            sq[index-1] = tmp2;
            index--; // No-no: decrementing loop control variable, problematic
            if (index == 0) 
                index++; // No-no: incrementing loop control variable
        }
    }